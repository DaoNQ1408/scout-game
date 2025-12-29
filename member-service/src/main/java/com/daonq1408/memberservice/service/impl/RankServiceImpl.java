package com.daonq1408.memberservice.service.impl;

import com.daonq1408.memberservice.dto.request.RankRequest;
import com.daonq1408.memberservice.dto.request.filter.RankRequestFilter;
import com.daonq1408.memberservice.dto.response.RankResponse;
import com.daonq1408.memberservice.entity.Rank;
import com.daonq1408.memberservice.entity.Section;
import com.daonq1408.memberservice.enums.ScoutElementStatus;
import com.daonq1408.memberservice.mapper.RankMapper;
import com.daonq1408.memberservice.repository.RankRepository;
import com.daonq1408.memberservice.service.inter.RankService;
import com.daonq1408.memberservice.service.inter.SectionService;
import com.daonq1408.memberservice.specification.RankSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {

    private final RankRepository rankRepository;
    private final RankMapper rankMapper;
    private final SectionService sectionService;


    @Override
    @Transactional
    public RankResponse createRank(RankRequest request) {

        Section section = sectionService.getById(request.getSectionId());

        Rank rank = rankMapper.toEntity(request, section);

        Rank savedRank = rankRepository.save(rank);

        return rankMapper.toResponse(savedRank);
    }


    @Override
    public Page<RankResponse> getByFilter(RankRequestFilter filter, Pageable pageable) {
        return rankRepository.findAll(
                RankSpec.filter(filter),
                pageable
        ).map(rankMapper::toResponse);
    }


    @Override
    public Rank findById(Long id) {
        return rankRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Rank not found with id: " + id)
                );
    }


    @Override
    public RankResponse updateRank(Long id, RankRequest request) {

        Section section = sectionService.getById(request.getSectionId());

        Rank rank = findById(id);

        rankMapper.updateRankFromRequest(request, section, rank);

        Rank updatedRank = rankRepository.save(rank);

        return rankMapper.toResponse(updatedRank);
    }


    @Override
    public RankResponse deleteRank(Long id) {

        Rank rank = findById(id);

        rank.setStatus(ScoutElementStatus.DELETED);

        Rank deletedRank = rankRepository.save(rank);

        return rankMapper.toResponse(deletedRank);
    }
}

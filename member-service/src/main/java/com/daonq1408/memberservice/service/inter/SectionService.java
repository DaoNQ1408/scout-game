package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.SectionRequest;
import com.daonq1408.memberservice.dto.request.filter.SectionRequestFilter;
import com.daonq1408.memberservice.dto.response.SectionResponse;
import com.daonq1408.memberservice.entity.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SectionService {
    SectionResponse createSection(SectionRequest sectionRequest);

    Page<SectionResponse> getByFilter(SectionRequestFilter filter, Pageable pageable);

    Section getById(Long id);

    SectionResponse updateSection(Long id, SectionRequest sectionRequest);

    SectionResponse deleteSection(Long id);
}

package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.SectionRequest;
import com.daonq1408.memberservice.dto.request.filter.SectionRequestFilter;
import com.daonq1408.memberservice.entity.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SectionService {
    Section createSection(SectionRequest sectionRequest);

    Page<Section> getByFilter(SectionRequestFilter filter, Pageable pageable);

    Section updateSection(Long id, SectionRequest sectionRequest);

    Section deleteSection(Long id);
}

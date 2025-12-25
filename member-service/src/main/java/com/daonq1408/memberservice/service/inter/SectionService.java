package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.SectionRequest;
import com.daonq1408.memberservice.entity.Section;

import java.util.List;

public interface SectionService {
    Section createSection(SectionRequest sectionRequest);

    List<Section> getByFilter(Long id,
                              String name,
                              String code);

    Section updateSection(Long id, SectionRequest sectionRequest);

    Section deleteSection(Long id);
}

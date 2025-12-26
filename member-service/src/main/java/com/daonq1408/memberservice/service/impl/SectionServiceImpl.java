package com.daonq1408.memberservice.service.impl;

import com.daonq1408.memberservice.mapper.SectionMapper;
import com.daonq1408.memberservice.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SectionServiceImpl{

    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;

}

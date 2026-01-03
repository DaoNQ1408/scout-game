package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.ProfileDetailRequest;
import com.daonq1408.memberservice.dto.request.filter.ProfileDetailRequestFilter;
import com.daonq1408.memberservice.entity.ProfileDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfileDetailService {

    ProfileDetail createProfileDetail(ProfileDetailRequest request);

    Page<ProfileDetail> getByFilter(ProfileDetailRequestFilter filter, Pageable pageable);

    ProfileDetail updateProfileDetail(Long id, ProfileDetailRequest request);

    ProfileDetail deleteProfileDetail(Long id);
}

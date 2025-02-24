package com.ronqueroc.pos_system.service;

import com.ronqueroc.pos_system.request.MemberSearchParam;
import com.ronqueroc.pos_system.response.MemberResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    public Page<MemberResponse> search(MemberSearchParam param, Pageable pageable);
}

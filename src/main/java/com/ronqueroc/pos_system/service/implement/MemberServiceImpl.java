package com.ronqueroc.pos_system.service.implement;

import com.ronqueroc.pos_system.entity.Member;
import com.ronqueroc.pos_system.projector.MemberProjector;
import com.ronqueroc.pos_system.repository.MemberCustomRepository;
import com.ronqueroc.pos_system.request.MemberSearchParam;
import com.ronqueroc.pos_system.response.MemberResponse;
import com.ronqueroc.pos_system.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    MemberCustomRepository memberCustomRepo;

    @Autowired
    public MemberServiceImpl(MemberCustomRepository memberCustomRepo) {
        this.memberCustomRepo = memberCustomRepo;
    }

    @Override
    public Page<MemberResponse> search(MemberSearchParam param, Pageable pageable) {
        Page<Member> page = memberCustomRepo.findPaging(param, pageable);

        List<MemberResponse> memberResList = page.getContent().stream()
                .map(MemberProjector::toResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(memberResList, pageable, page.getTotalElements());
    }
}

package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.request.MemberSearchParam;
import com.ronqueroc.pos_system.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController extends BaseController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public Object search(
            @RequestParam(required = false) String keyword,
            @SortDefault Pageable pageable
    ) {
        MemberSearchParam param = MemberSearchParam.builder()
                .keyword(keyword)
                .build();

        return success(memberService.search(param, pageable));
    }
}

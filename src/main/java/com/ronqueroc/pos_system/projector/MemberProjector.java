package com.ronqueroc.pos_system.projector;

import com.ronqueroc.pos_system.entity.Member;
import com.ronqueroc.pos_system.response.MemberResponse;

public class MemberProjector {

    public static MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}

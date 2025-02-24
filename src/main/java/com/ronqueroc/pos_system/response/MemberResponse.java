package com.ronqueroc.pos_system.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MemberResponse {
    private int id;

    private String name;

    private String phoneNumber;
}

package com.example.shop.domain;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    private String name;
    private String id;
    private String password;
    private String email;
    private String phone;
}

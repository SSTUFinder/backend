package com.sstufinder.main.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AuthModel {
    private String login;
    private String password;
    private String role;

}

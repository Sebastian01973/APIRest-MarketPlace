package com.tunja.market.domain.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String user;
    private String password;

}

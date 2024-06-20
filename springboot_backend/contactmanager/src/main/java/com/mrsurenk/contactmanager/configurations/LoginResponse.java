package com.mrsurenk.contactmanager.configurations;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String accessToken;

    private Long expiresIn;

    private String userName;

}

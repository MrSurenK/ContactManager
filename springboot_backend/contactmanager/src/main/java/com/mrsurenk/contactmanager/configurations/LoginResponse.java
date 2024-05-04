package com.mrsurenk.contactmanager.configurations;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class LoginResponse {
    private String token;

    private Long expiresIn;

}

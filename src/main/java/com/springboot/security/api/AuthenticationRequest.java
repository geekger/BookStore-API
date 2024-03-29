package com.springboot.security.api;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class AuthenticationRequest {

    @Email @Length(min=5, max=50)
    private String email;

    @Length(min =5, max=50)
    private String password;
}

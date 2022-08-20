package com.cahuete.fepolcompte.auth;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AuthRequest {
    @NotNull
    @Email
    @Length(min = 5, max = 50)
    private String email;

    @NotNull @Length(min = 5, max = 10)
    private String mdp;

    public String getPassword() {
        return mdp;
    }

    public String getEmail(){
        return email;
    }
}

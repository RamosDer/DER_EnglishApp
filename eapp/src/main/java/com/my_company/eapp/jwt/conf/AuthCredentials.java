package com.my_company.eapp.jwt.conf;

import lombok.Data;

@Data
public class AuthCredentials {
    private String username;
    private String password;
}

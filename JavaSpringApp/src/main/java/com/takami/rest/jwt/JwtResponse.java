package com.takami.rest.jwt;

import java.util.List;

public class JwtResponse {
   String jwt;
   List<String> roles;

    public JwtResponse(String jwt, List<String> roles) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

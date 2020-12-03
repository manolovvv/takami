package com.takami.rest.jwt;

import java.util.List;

public class JwtResponse {
   String jwt;
   String role;
   Long id;

    public JwtResponse(String jwt, List<String> roles, Long id) {
        this.jwt = jwt;
       this.id = id;
        this.role = roles.get(0).toString();
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

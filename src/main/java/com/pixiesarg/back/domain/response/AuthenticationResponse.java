package com.pixiesarg.back.domain.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {

    private String username;
    private String token;
    private Long id;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String username, String token, Long id) {
        this.username = username;
        this.token = token;
        this.id = id;
    }

}


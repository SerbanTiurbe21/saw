package com.saw.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponseDTO {
    @JsonProperty("access_token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}

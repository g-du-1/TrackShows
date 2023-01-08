package com.gd.trackshows.api.trakt.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TraktUser {
    @JsonProperty("username")
    private String username;

    public String getUsername() {
        return username;
    }
}

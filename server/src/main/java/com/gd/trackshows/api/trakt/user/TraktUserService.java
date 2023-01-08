package com.gd.trackshows.api.trakt.user;

import com.gd.trackshows.shared.user.ApiUserInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TraktUserService implements ApiUserInterface<TraktUser> {
    private final String clientID = System.getenv("TRAKT_CLIENT_ID");

    private final RestTemplate restTemplate;

    public TraktUserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public TraktUser getUser(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        headers.set("trakt-api-version", "2");
        headers.set("trakt-api-key", clientID);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        TraktUser response = restTemplate.exchange("https://api.trakt.tv/users/me", HttpMethod.GET, entity, TraktUser.class).getBody();

        assert response != null;

        return response;
    }
}

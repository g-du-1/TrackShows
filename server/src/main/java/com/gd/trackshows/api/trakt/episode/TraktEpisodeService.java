package com.gd.trackshows.api.trakt.episode;

import com.gd.trackshows.shared.auth.OAuthSessionInfo;
import com.gd.trackshows.shared.episode.ApiEpisode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TraktEpisodeService implements ApiEpisode<TraktEpisode> {
    private final String clientID = System.getenv("TRAKT_CLIENT_ID");

    private final OAuthSessionInfo sessionInfo;
    private final RestTemplate restTemplate;

    @Autowired
    public TraktEpisodeService(OAuthSessionInfo sessionInfo, RestTemplateBuilder restTemplateBuilder) {
        this.sessionInfo = sessionInfo;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public TraktEpisode getEpisode(String id, String season, String episode) {
        String tokenInSession = sessionInfo.getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(tokenInSession);
        headers.set("trakt-api-version", "2");
        headers.set("trakt-api-key", clientID);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = String.format("https://api.trakt.tv/shows/%s/seasons/%s/episodes/%s", id, season, episode);

        TraktEpisode response = restTemplate.exchange(url, HttpMethod.GET, entity, TraktEpisode.class).getBody();

        assert response != null;

        return response;
    }
}

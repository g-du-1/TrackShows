package com.gd.trackshows.api.trakt.auth;

import com.gd.trackshows.shared.auth.OAuthInterface;
import com.gd.trackshows.shared.auth.OAuthSessionInfo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class TraktAuthService implements OAuthInterface {

    private final String clientID = System.getenv("TRAKT_CLIENT_ID");
    private final String clientSecret = System.getenv("TRAKT_CLIENT_SECRET");
    private final String redirURL = System.getenv("TRAKT_REDIR_URL");
    private final String loginURL = System.getenv("TRAKT_LOGIN_URL");
    private final String tokenURL = System.getenv("TRAKT_TOKEN_URL");

    private final RestTemplate restTemplate;

    private final OAuthSessionInfo sessionInfo;

    public TraktAuthService(RestTemplateBuilder restTemplateBuilder, OAuthSessionInfo oAuthSessionInfo) {
        this.restTemplate = restTemplateBuilder.build();
        this.sessionInfo = oAuthSessionInfo;
    }

    public RedirectView initLogin() {
        String idReplacedURL = loginURL.replace("${TRAKT_CLIENT_ID}", clientID);
        String URL = idReplacedURL.replace("${TRAKT_REDIR_URL}", redirURL);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(URL);
        return redirectView;
    }

    public String authCallback(String code) {
        String tokenInSession = sessionInfo.getAccessToken();

        if (tokenInSession == null) {
            String accessToken = getAccessToken(code, clientID, clientSecret);
            sessionInfo.setAccessToken(accessToken);
            return accessToken;
        }

        return tokenInSession;
    }

    public String getAccessToken(String code, String clientID, String clientSecret) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("client_id", clientID);
        map.put("client_secret", clientSecret);
        map.put("redirect_uri", redirURL);
        map.put("grant_type", "authorization_code");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        TraktAuthResponse response = restTemplate.postForObject(tokenURL, entity, TraktAuthResponse.class);

        assert response != null;

        return response.getAccessToken();
    }
}
package com.gd.trackshows.shared.auth;

import org.springframework.web.servlet.view.RedirectView;

public interface OAuth {
    RedirectView initLogin();

    String authCallback(String code);

    String getAccessToken(String code, String clientID, String clientSecret);
}

package com.gd.trackshows.shared.auth;

import org.springframework.web.servlet.view.RedirectView;

public interface OAuthInterface {
    RedirectView initLogin();
}

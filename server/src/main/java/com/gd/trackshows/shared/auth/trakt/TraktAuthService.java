package com.gd.trackshows.shared.auth.trakt;

import com.gd.trackshows.shared.auth.OAuthInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class TraktAuthService implements OAuthInterface, TraktAuthInterface {

    private final String clientID = System.getenv("TRAKT_CLIENT_ID");
    private final String redirURL = System.getenv("TRAKT_REDIR_URL");
    private final String loginURL = System.getenv("TRAKT_LOGIN_URL");

    public RedirectView initLogin() {
        String idReplacedURL = loginURL.replace("${TRAKT_CLIENT_ID}", clientID);
        String URL = idReplacedURL.replace("${TRAKT_REDIR_URL}", redirURL);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(URL);
        return redirectView;
    }

}
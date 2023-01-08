package com.gd.trackshows.api.trakt.auth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootTest
public class TraktAuthServiceTest {

    @Autowired
    private TraktAuthService traktAuthService;

    @Test
    public void buildsTheRedirectUrlProperly() {
        RedirectView resultingView = traktAuthService.initLogin();
        String redirUrl = resultingView.getUrl();
        assert redirUrl != null;
        Assertions.assertTrue(redirUrl.contains("trakt.tv"));
        Assertions.assertFalse(redirUrl.contains("${TRAKT_CLIENT_ID}"));
        Assertions.assertFalse(redirUrl.contains("${TRAKT_REDIR_URL}"));
    }

}
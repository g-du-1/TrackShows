package com.gd.trackshows.shared.auth.trakt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class TraktAuthController {

    private final TraktAuthService traktAuthService;

    @Autowired
    public TraktAuthController(TraktAuthService traktAuthService) {
        this.traktAuthService = traktAuthService;
    }

    @RequestMapping("/api/v1/auth/trakt/")
    public RedirectView initLogin() {
        return traktAuthService.initLogin();
    }

    @RequestMapping("/api/v1/auth/trakt/callback")
    public RedirectView authCallback(@RequestParam(name = "code") String code) {
        return traktAuthService.authCallback(code);
    }

}
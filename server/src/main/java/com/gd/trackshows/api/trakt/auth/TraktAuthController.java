package com.gd.trackshows.api.trakt.auth;

import com.gd.trackshows.api.trakt.user.TraktUser;
import com.gd.trackshows.api.trakt.user.TraktUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class TraktAuthController {

    private final TraktAuthService traktAuthService;
    private final TraktUserService traktUserService;

    @Autowired
    public TraktAuthController(TraktAuthService traktAuthService, TraktUserService traktUserService) {
        this.traktAuthService = traktAuthService;
        this.traktUserService = traktUserService;
    }

    @RequestMapping("/api/v1/auth/trakt/")
    public RedirectView initLogin() {
        return traktAuthService.initLogin();
    }

    @RequestMapping("/api/v1/auth/trakt/callback")
    public String authCallback(@RequestParam(name = "code") String code) {
        String token = traktAuthService.authCallback(code);
        TraktUser user = traktUserService.getUser(token);
        return user.getUsername();
    }

}
package com.gd.trackshows.api.trakt.auth;

import com.gd.trackshows.api.trakt.user.TraktUser;
import com.gd.trackshows.api.trakt.user.TraktUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1/trakt/auth")
public class TraktAuthController {

    private final TraktAuthService traktAuthService;
    private final TraktUserService traktUserService;

    @Autowired
    public TraktAuthController(TraktAuthService traktAuthService, TraktUserService traktUserService) {
        this.traktAuthService = traktAuthService;
        this.traktUserService = traktUserService;
    }

    @GetMapping
    public RedirectView initLogin() {
        return traktAuthService.initLogin();
    }

    @GetMapping("/callback")
    public String authCallback(@RequestParam(name = "code") String code) {
        String token = traktAuthService.authCallback(code);
        TraktUser user = traktUserService.getUser(token);
        return user.getUsername();
    }

}
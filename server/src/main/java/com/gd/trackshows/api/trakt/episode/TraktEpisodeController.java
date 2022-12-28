package com.gd.trackshows.api.trakt.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraktEpisodeController {
    private final TraktEpisodeService traktEpisodeService;

    @Autowired
    public TraktEpisodeController(TraktEpisodeService traktEpisodeService) {
        this.traktEpisodeService = traktEpisodeService;
    }

    @RequestMapping("/api/v1/trakt/upcoming")
    public String getUpcomingEpisodes() {
        return traktEpisodeService.getUpcomingEpisodes();
    }
}

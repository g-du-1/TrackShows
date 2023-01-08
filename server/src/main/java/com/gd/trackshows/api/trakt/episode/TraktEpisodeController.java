package com.gd.trackshows.api.trakt.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trakt/episode")
public class TraktEpisodeController {
    private final TraktEpisodeService traktEpisodeService;

    @Autowired
    public TraktEpisodeController(TraktEpisodeService traktEpisodeService) {
        this.traktEpisodeService = traktEpisodeService;
    }

    @GetMapping
    public TraktEpisode getEpisode(@RequestParam String id, @RequestParam String season, @RequestParam String episode) {
        return traktEpisodeService.getEpisode(id, season, episode);
    }
}

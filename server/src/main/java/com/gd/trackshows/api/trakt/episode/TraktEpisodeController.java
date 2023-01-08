package com.gd.trackshows.api.trakt.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trakt/episode")
public class TraktEpisodeController {
    private final TraktEpisodeService traktEpisodeService;

    @Autowired
    public TraktEpisodeController(TraktEpisodeService traktEpisodeService) {
        this.traktEpisodeService = traktEpisodeService;
    }

    @GetMapping("/{id}/{season}/{episode}")
    public TraktEpisode getEpisode(@PathVariable String id, @PathVariable String season, @PathVariable String episode) {
        return traktEpisodeService.getEpisode(id, season, episode);
    }
}

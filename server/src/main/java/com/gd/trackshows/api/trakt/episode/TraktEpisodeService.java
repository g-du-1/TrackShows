package com.gd.trackshows.api.trakt.episode;

import com.gd.trackshows.shared.episode.ApiEpisodeInterface;
import org.springframework.stereotype.Service;

@Service
public class TraktEpisodeService implements ApiEpisodeInterface<String> {
    public String getUpcomingEpisodes() {
        return "";
    }
}

package com.gd.trackshows.shared.episode;

public interface ApiEpisodeInterface<T> {
    T getEpisode(String id, String season, String episode);
}

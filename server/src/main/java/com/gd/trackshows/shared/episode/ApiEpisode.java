package com.gd.trackshows.shared.episode;

public interface ApiEpisode<T> {
    T getEpisode(String id, String season, String episode);
}

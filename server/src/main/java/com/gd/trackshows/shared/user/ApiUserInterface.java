package com.gd.trackshows.shared.user;

public interface ApiUserInterface<T> {
    T getUser(String token);
}

package com.gd.trackshows.shared.user;

public interface ApiUser<T> {
    T getUser(String token);
}

package com.github.frankiesardo.gaagbt.boundary;

import com.github.frankiesardo.gaagbt.entity.Repositories;

public interface GithubApi {
    Repositories searchRepositories(String request);
}

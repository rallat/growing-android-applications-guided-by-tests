package com.github.frankiesardo.gaagbt.boundary.mock;

import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;

import java.util.Arrays;

public interface MockSearchRepositories {

    public static final Repository GITHUB = new Repository("GitHub Android App");
    public static final Repository NOVODA = new Repository("Examples of Android applications");
    public static final Repository FACEBOOK = new Repository("Facebook SDK for Android");

    public static final Repositories ANDROID_REPOSITORIES = new Repositories(Arrays.asList(GITHUB, NOVODA, FACEBOOK));

    public static final String ANDROID_KEYWORD = "android";

    public static final String SEARCH_REPOSITORIES_FILE_NAME = "search_repositories.json";
}

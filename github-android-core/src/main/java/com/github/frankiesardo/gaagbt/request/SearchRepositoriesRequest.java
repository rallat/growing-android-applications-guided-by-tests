package com.github.frankiesardo.gaagbt.request;

public class SearchRepositoriesRequest {
    private String keyword;

    public SearchRepositoriesRequest(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}

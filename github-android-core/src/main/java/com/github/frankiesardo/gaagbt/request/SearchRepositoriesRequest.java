package com.github.frankiesardo.gaagbt.request;

public class SearchRepositoriesRequest implements Request {
    private String keyword;

    public SearchRepositoriesRequest(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchRepositoriesRequest request = (SearchRepositoriesRequest) o;

        if (!keyword.equals(request.keyword)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return keyword.hashCode();
    }
}

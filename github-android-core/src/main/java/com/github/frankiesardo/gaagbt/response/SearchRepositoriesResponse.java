package com.github.frankiesardo.gaagbt.response;

import com.github.frankiesardo.gaagbt.entity.Repositories;

public class SearchRepositoriesResponse {

    private Repositories repositories;

    public SearchRepositoriesResponse(Repositories repositories) {
        this.repositories = repositories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchRepositoriesResponse response = (SearchRepositoriesResponse) o;

        if (repositories != null ? !repositories.equals(response.repositories) : response.repositories != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return repositories != null ? repositories.hashCode() : 0;
    }
}

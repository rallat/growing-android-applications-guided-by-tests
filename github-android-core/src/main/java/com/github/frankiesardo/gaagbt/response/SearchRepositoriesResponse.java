package com.github.frankiesardo.gaagbt.response;

import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.request.Request;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;

public class SearchRepositoriesResponse implements Response<Repositories> {

    private final Repositories repositories;
    private final SearchRepositoriesRequest request;

    public SearchRepositoriesResponse(Repositories repositories, SearchRepositoriesRequest request) {
        this.repositories = repositories;
        this.request = request;

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

    @Override
    public Repositories getResult() {
        return repositories;
    }

    @Override
    public Request getRequest() {
        return request;
    }

    public boolean isFrom(Request request) {
        return this.request.equals(request);
    }
}

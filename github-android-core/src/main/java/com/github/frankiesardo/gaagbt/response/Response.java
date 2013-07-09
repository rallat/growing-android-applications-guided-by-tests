package com.github.frankiesardo.gaagbt.response;

import com.github.frankiesardo.gaagbt.request.Request;

public interface Response<T> {
    T getResult();

    Request getRequest();
}

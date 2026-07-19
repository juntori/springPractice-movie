package com.example.movie.exception;

import org.springframework.http.HttpStatus;

public class MovieNotFoundException extends ServiceException {
    public MovieNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}

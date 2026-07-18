package com.example.movie.review.dto;

import lombok.Getter;

@Getter
public class ReviewUpdateResponse {
    private final Long id;
    private final String content;

    public ReviewUpdateResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}

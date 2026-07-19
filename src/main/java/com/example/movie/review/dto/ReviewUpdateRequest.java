package com.example.movie.review.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ReviewUpdateRequest {
    @NotBlank(message = "리뷰를 입력해주세요!")
    private String content;
}

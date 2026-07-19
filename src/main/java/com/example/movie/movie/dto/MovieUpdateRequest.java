package com.example.movie.movie.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MovieUpdateRequest {
    @NotBlank(message = "영화 제목을 입력해주세요!")
    private String title;
}

package com.example.movie.review.controller;

import com.example.movie.review.dto.*;
import com.example.movie.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<ReviewCreateResponse> create(
            @PathVariable Long movieId,
            @Valid @RequestBody ReviewCreateRequest request
    ) {
        return ResponseEntity.ok(reviewService.create(movieId, request));
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<List<ReviewGetResponse>> getAll(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService.getAll(movieId));
    }

    @GetMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<ReviewCreateResponse> getOne(@PathVariable Long reviewId) {
        return ResponseEntity.ok(reviewService.getOne(reviewId));
    }

    @PutMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<ReviewUpdateResponse> update(
            @PathVariable Long reviewId,
            @Valid @RequestBody ReviewUpdateRequest request
    ) {
        return ResponseEntity.ok(reviewService.update(reviewId, request));
    }

    @DeleteMapping("/movies/{movieId}/reviews/{reviewId}")
    public void delete(@PathVariable Long reviewId){
        reviewService.delete(reviewId);
    }
}

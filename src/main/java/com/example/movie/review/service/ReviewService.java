package com.example.movie.review.service;

import com.example.movie.movie.entity.Movie;
import com.example.movie.movie.repository.MovieRepository;
import com.example.movie.review.dto.*;
import com.example.movie.review.entity.Review;
import com.example.movie.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;


    @Transactional
    public ReviewCreateResponse create(Long movieId, ReviewCreateRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("없는 영화 입니다.")
        );
        Review review = new Review(request.getContent(), movie);
        reviewRepository.save(review);
        return new ReviewCreateResponse(
                review.getId(),
                review.getContent()
        );
    }

    @Transactional(readOnly = true)
    public List<ReviewGetResponse> getAll(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("없는 영화 입니다.")
        );
        List<Review> reviews = reviewRepository.findByMovie(movie);
        return reviews.stream()
                .map(review -> new ReviewGetResponse(
                review.getId(),
                review.getContent()
        )).toList();
    }

    @Transactional(readOnly = true)
    public ReviewCreateResponse getOne(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("없는 리뷰입니다.")
        );
        return new ReviewCreateResponse(
                review.getId(),
                review.getContent()
        );
    }

    @Transactional
    public ReviewUpdateResponse update(Long reviewId, ReviewUpdateRequest request) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("없는 리뷰입니다.")
        );
        review.update(request.getContent());
        return new ReviewUpdateResponse(
                review.getId(),
                review.getContent()
        );
    }

    public void delete(Long reviewId) {
        Boolean existence = reviewRepository.existsById(reviewId);
        if (!existence){
            throw new IllegalArgumentException("없는 리뷰입니다.");
        }
        reviewRepository.deleteById(reviewId);
    }
}

package com.example.movie.review.repository;

import com.example.movie.movie.entity.Movie;
import com.example.movie.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovie(Movie movie);
}

package com.example.movie.review.repository;

import com.example.movie.movie.entity.Movie;
import com.example.movie.movie.repository.MovieRepository;
import com.example.movie.review.entity.Review;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Test
    @DisplayName("영화 제목으로 영화 조회")
    void findByMovie(){
        // given
        Movie movie = new Movie("어벤져스");
        movieRepository.save(movie);

        Review review = new Review("완전 꿀잼!!!", movie);
        reviewRepository.save(review);

        // when
        List<Review> reviews = reviewRepository.findByMovie(movie);

        // then
        assertThat(reviews).isNotNull();
        assertThat(reviews).contains(review);
    }

}
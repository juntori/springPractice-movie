package com.example.movie.movie.service;

import com.example.movie.movie.dto.*;
import com.example.movie.movie.entity.Movie;
import com.example.movie.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional
    public MovieCreateResponse create(MovieCreateRequest request) {
        Movie movie = new Movie(request.getTitle());
        movieRepository.save(movie);
        return new MovieCreateResponse(
                movie.getId(),
                movie.getTitle()
        );
    }

    @Transactional(readOnly = true)
    public List<MovieGetResponse> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movie -> new MovieGetResponse(
                        movie.getId(),
                        movie.getTitle()
                )).toList();
    }

    @Transactional(readOnly = true)
    public MovieGetResponse getOne(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("없는 영화 입니다.")
        );
        return new MovieGetResponse(
                movie.getId(),
                movie.getTitle()
        );
    }

    public MovieUpdateResponse update(Long movieId, MovieUpdateRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("없는 영화입니다.")
        );
        movie.update(request.getTitle());
        return new MovieUpdateResponse(
                movie.getId(),
                movie.getTitle()
        );
    }

    public void delete(Long movieId) {
        boolean existence = movieRepository.existsById(movieId);
        if(!existence){
            throw new IllegalArgumentException("없는 영화입니다.");
        }
    }
}

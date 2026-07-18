package com.example.movie.movie.controller;

import com.example.movie.movie.dto.*;
import com.example.movie.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<MovieCreateResponse> create(
            @RequestBody MovieCreateRequest request
    ) {
        return ResponseEntity.ok(movieService.create(request));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieGetResponse>> getAll(){
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<MovieGetResponse> getOne(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(movieService.getOne(movieId));
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<MovieUpdateResponse> update(
            @PathVariable Long movieId,
            @RequestBody MovieUpdateRequest request
    ) {
        return ResponseEntity.ok(movieService.update(movieId, request));
    }

    @DeleteMapping("/movies/{movieId}")
    public void delete(@PathVariable Long movieId){
        movieService.delete(movieId);
    }

}

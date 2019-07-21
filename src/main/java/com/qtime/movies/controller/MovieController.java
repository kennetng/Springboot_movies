package com.qtime.movies.controller;

import com.qtime.movies.repository.MovieRepository;
import com.qtime.movies.model.Movie;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @AutoWired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getAllUsers() {
        return movieRepository.findAll();
    }

    // Get movie by id
    @PutMapping("/users/{id}")
    public ResponseEntity<Movie> getMoviesById(@PathVariable(value = "id") Long movieId) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie not found on :: " + movieId));

    }
}

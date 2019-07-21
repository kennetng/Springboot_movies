package com.qtime.movies.controller;

import com.qtime.movies.service.MovieService;
import com.qtime.movies.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable String movieId) {
        return movieService.getMovie(movieId);
    }

    @PostMapping("/movies")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

}

package com.qtime.movies.controller;

import com.qtime.movies.model.Genre;
import com.qtime.movies.repository.GenreRepository;
import com.qtime.movies.service.GenreService;
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

    @Autowired
    GenreService genreService;

    @GetMapping("/movies")
    public List getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/movies/search")
    public List getMoviesBySearch(@RequestParam("term") String searchTerm) {
        return movieService.getMoviesBySearch(searchTerm);
    }

    @PostMapping("/movies")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovieById(@PathVariable long id) {
        movieService.deleteMovie(id);
    }

    @PutMapping("/movies/{movieId}/genre/{genreId}")
    public void setGenre(@PathVariable long movieId, @PathVariable long genreId) {
        Genre genre = genreService.getGenreById(genreId);
        Movie movie = movieService.getMovieById(movieId);
        System.out.println("Movie genre before: " + movie.getGenre());
        System.out.println("Genre movies before: " + genre.getMovies().toString());

        movie.setGenre(genre);
        genre.addMovie(movie);

        movieService.updateMovie(movie);
        genreService.updateGenre(genre);

        System.out.println("Movie genre after: " + movie.getGenre());
        System.out.println("Genre movies after: " + genre.getMovies().toString());
    }
}

package com.qtime.movies.service;

import com.qtime.movies.model.Genre;
import com.qtime.movies.model.Movie;
import com.qtime.movies.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List getAllMovies() {
        return (List) movieRepository.findAll();
    }

    public Movie getMovieById(long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getMoviesBySearch(String searchTerm) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getTitle().contains(searchTerm)) {
                movies.add(movie);
            }
        }
        return movies;
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(long id) {
        movieRepository.deleteById(id);
    }
}

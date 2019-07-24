package com.qtime.movies.service;

import com.qtime.movies.model.Genre;
import com.qtime.movies.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List getAllGenres() {
        return (List) genreRepository.findAll();
    }

    public Genre getGenreById(long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(long id) {
        genreRepository.deleteById(id);
    }

    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }
}

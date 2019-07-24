package com.qtime.movies.controller;

import com.qtime.movies.model.Genre;
import com.qtime.movies.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreController {

    @Autowired
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public List getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/genres/{id}")
    public Genre getGenreById(@PathVariable long id) {
        return genreService.getGenreById(id);
    }

    @PostMapping("/genres")
    public void addGenre(@RequestBody Genre genre) {
        genreService.addGenre(genre);
    }
}

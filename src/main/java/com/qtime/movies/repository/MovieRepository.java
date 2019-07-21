package com.qtime.movies.repository;

import com.qtime.movies.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

package com.qtime.movies.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Movie {

    @Id
    private String id = "";
    private String title = "";
    private float rating = 0;


    public Movie(String id, String title, float rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    public Movie() {}

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }
}

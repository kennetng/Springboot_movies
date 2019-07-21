package com.qtime.movies.model;

import javax.xml.bind.annotation.XmlID;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;

    @Column(name = "title", nullable = false)
    private final String title;

    @Column(name = "rating", nullable = true)
    private final float rating;

    public Movie(long id, String title, float rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }
}

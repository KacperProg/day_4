package com.example.Spring_Cinema_Lab.models;

import jakarta.persistence.*;


@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private float rating;
    @Column(name = "duration")
    private int duration;

    public Movies(String title, float rating, int duration){
        this.title = title;
        this.rating = rating;
        this.duration = duration;

    }

    public Movies(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

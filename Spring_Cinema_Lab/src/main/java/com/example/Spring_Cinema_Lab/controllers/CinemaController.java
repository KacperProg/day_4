package com.example.Spring_Cinema_Lab.controllers;


import com.example.Spring_Cinema_Lab.models.Movies;
import com.example.Spring_Cinema_Lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {

    Movies movies;
    @Autowired
    MovieService movieService;


    @PostMapping
    public ResponseEntity<String> newMovie(String title, float rating, int duration){
        movieService.addNewMovie(title, rating, duration);
        return new ResponseEntity<>(title, HttpStatus.CREATED);
    }

    @GetMapping
    public Movies getMovieStatus(){
        Optional<Movies> movies = movieService.displayAllMovies();
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<> getMovieStatusByID(@PathVariable long id){
        Optional<Movies> movies = movieService.displayMoviesByID(id);
        return new ResponseEntity<>(movies.get().getTitle(), HttpStatus.OK);
    }

}

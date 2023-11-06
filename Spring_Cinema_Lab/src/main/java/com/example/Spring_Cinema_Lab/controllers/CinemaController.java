package com.example.Spring_Cinema_Lab.controllers;


import com.example.Spring_Cinema_Lab.models.Movies;
import com.example.Spring_Cinema_Lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {

    Movies movies;
    @Autowired
    MovieService movieService;


    @PostMapping
    public ResponseEntity<String> newMovie(@RequestBody String title, float rating, int duration){
        movieService.addNewMovie(title, rating, duration);
        return new ResponseEntity<>(title, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Movies>> getMovieStatus(){
        ArrayList<Movies> movies = movieService.displayAllMovies();
        return new ResponseEntity<> (movies, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Movies>> getMovieStatusByID(@PathVariable long id){
        ArrayList<Movies> movies = movieService.displayMoviesByID(id);
        return new ResponseEntity<>(movies.get(), HttpStatus.OK);
    }

}

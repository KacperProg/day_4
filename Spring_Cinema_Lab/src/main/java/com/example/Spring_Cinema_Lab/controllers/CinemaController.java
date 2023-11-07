package com.example.Spring_Cinema_Lab.controllers;


import com.example.Spring_Cinema_Lab.models.Movies;
import com.example.Spring_Cinema_Lab.repositories.MovieRepository;
import com.example.Spring_Cinema_Lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {

    @Autowired
    MovieService movieService;


    @PostMapping
    public ResponseEntity<Movies> newMovie(@RequestBody Movies movies){
        Movies movies1 = movieService.addNewMovie(movies);
        return new ResponseEntity<>(movies1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movies>> getMovieStatus(){
        List<Movies> movies = movieService.displayAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movies> getMovieStatusByID(@PathVariable Long id){
        Optional<Movies> movie = movieService.displayMoviesByID(id);
        if (movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}

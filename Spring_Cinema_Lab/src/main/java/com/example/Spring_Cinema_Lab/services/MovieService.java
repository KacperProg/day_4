package com.example.Spring_Cinema_Lab.services;

import com.example.Spring_Cinema_Lab.models.Movies;
import com.example.Spring_Cinema_Lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movies addNewMovie(Movies movie){
        movieRepository.save(movie);
        return movie;
    }

    public List<Movies> displayAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movies> displayMoviesByID(long id){
        return movieRepository.findById(id);
    }

}

package com.example.Spring_Cinema_Lab.services;

import com.example.Spring_Cinema_Lab.models.Movies;
import com.example.Spring_Cinema_Lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    private Movies;

    public MovieService(){
    }

    public String addNewMovie(String title, float rating, int duration){
        Movies movie = new Movies();
        return movie.getTitle() + " was added to the database";
    }

    public ArrayList<Movies> displayAllMovies(){
        return movieRepository.findAll();
    }

    public ArrayList<Movies> displayMoviesByID(long id){
        return movieRepository.findAllById(id);
    }

}

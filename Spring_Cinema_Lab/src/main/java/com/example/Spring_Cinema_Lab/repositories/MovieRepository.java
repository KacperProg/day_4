package com.example.Spring_Cinema_Lab.repositories;

import com.example.Spring_Cinema_Lab.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movies, Long> {

}

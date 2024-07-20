package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.Movie;
import com.movieflix.repositories.MovieRepository;


@Service
public class MovieServiceImplementation implements MovieService {
	
	@Autowired
	MovieRepository mRepo;
	@Override
	public String addMovie(Movie movie) {
		mRepo.save(movie);
		return "Movie Saved Successfully";
	}
	@Override
	public List<Movie> viewAllMovies() {
		List<Movie> moviesList = mRepo.findAll();
		return moviesList;
	}
	
	
	
}

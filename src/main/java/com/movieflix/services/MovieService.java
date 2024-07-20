package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.Movie;

public interface MovieService {
	
	public String addMovie(Movie movie);
	
	public List<Movie> viewAllMovies();
	
	
}

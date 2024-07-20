package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.movieflix.entities.Movie;
import com.movieflix.services.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService mServ;
	
	@PostMapping("add_Movie")
	public String addMovie(@ModelAttribute Movie movie) {
		mServ.addMovie(movie);
		return "movieAddSuccess";
	}
	
	@GetMapping("map_viewallmovies")
	public String viewAllMovies(Model model) {
		List<Movie> lmovies = mServ.viewAllMovies();
		model.addAttribute("movies", lmovies);
		return "allMovieDetails";
	}
	
	@GetMapping("viewmoviesuser")
	public String viewMovieUser(Model model) {
		List<Movie> lmovies = mServ.viewAllMovies();
		model.addAttribute("movies", lmovies);
		return "viewmoviesuser";
	}
}

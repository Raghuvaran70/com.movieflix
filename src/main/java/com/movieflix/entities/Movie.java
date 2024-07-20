package com.movieflix.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String moviename;
	String movieLink;
	String genre;
	double cost;
	String directorName;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int id, String moviename, String movieLink, String genre, double cost, String directorName) {
		super();
		this.id = id;
		this.moviename = moviename;
		this.movieLink = movieLink;
		this.genre = genre;
		this.cost = cost;
		this.directorName = directorName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getMovieLink() {
		return movieLink;
	}
	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", moviename=" + moviename + ", movieLink=" + movieLink + ", genre=" + genre
				+ ", cost=" + cost + ", directorName=" + directorName + "]";
	}
	
	
	
}

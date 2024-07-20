package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.MovieUser;

import jakarta.transaction.Transactional;

public interface MovieUserRepository extends JpaRepository<MovieUser, Integer> {

	
	public MovieUser findByEmailId(String emailId);
	@Transactional
	public void deleteByEmailId(String emailId);
	
}

package com.movieflix.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entities.Movie;
import com.movieflix.entities.MovieUser;
import com.movieflix.services.MovieService;
import com.movieflix.services.MovieUserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	MovieUserService mUserServ;
	@Autowired
	MovieService movserv;
	
	@PostMapping("register")
	public String addMovieUser(@ModelAttribute MovieUser user) {
		if(mUserServ.emailExistOrNot(user.getEmailId())==false) {
			mUserServ.addMovieUser(user);
			return "regSuccess";
		}
		
		return "regFailed";
	}
	
	@PostMapping("login")
	public String verifyUserDetails(@RequestParam String emailId,String password,HttpSession session,Model model) {
		if(mUserServ.emailExistOrNot(emailId)) {
			if(mUserServ.verifyUserDetails(emailId, password)) {
				    session.setAttribute("email", emailId);
				    MovieUser movieuser = mUserServ.getUser(emailId);
				    model.addAttribute("user", movieuser);
				if(emailId.equalsIgnoreCase("admin@gmail.com")) {
					
					return "adminHome";
				}else {
					return "userHome";
				}
			}
		}
		return "loginFailed";
	}
	
	@GetMapping("map_viewallusers")
	public String fetchAllUsersData(Model model) {
		List<MovieUser> allUsers= mUserServ.fetchAll();
		model.addAttribute("users", allUsers);
		return "allUserDetails";
		
	}
	
	
	@GetMapping("exploremovies")
	public String exploreMovies(Model model, HttpSession session) {
		//getting the email from session
		String email = (String)session.getAttribute("email");
		//getting the user details from db using email-ID
		MovieUser user = mUserServ.getUser(email);
		//checking whether the user is premium 
		if(user.isPremium()) {
			//getting the list of movies
			List<Movie> lmovies = movserv.viewAllMovies();
			//adding the movie details in model
			model.addAttribute("movies", lmovies);
			//show movies
			return "viewmoviesuser";
		}else {
			//otherwise, make payment
			return "payment";
		}
	}
	
	
	@GetMapping("/update")
	public String updateUser(@RequestParam String id,Model model) {
		MovieUser mu = mUserServ.getUser(id);
		model.addAttribute("user", mu);
		return "updateUserPage";
		
	}
	@PostMapping("updateUser")
	public String updateUserDetails(@ModelAttribute MovieUser user) {
		MovieUser us = mUserServ.getUser(user.getEmailId());
		us.setAddress(user.getAddress());
		us.setName(user.getName());
		us.setGender(user.getGender());
		us.setPhoneNo(user.getPhoneNo());
		us.setPassword(user.getPassword());
		mUserServ.updateUser(us);
		return "userUpdatedSuccess";
	}
	
	@GetMapping("map_deleteuser")
	public String deleteUserDetails(@RequestParam String id,Model model) {
			 mUserServ.deleteUser(id);
		 List<MovieUser> muall = mUserServ.fetchAll();
		 model.addAttribute("users", muall);
		 return "allUserDetails";
	}
	
	@GetMapping("home")
	public String home(HttpSession session,Model model) {
		String emailId = (String)session.getAttribute("email");
			MovieUser mus = mUserServ.getUser(emailId);
			model.addAttribute("user", mus);
		if(emailId==null) {
			return "index";
		}
		else if (emailId.equalsIgnoreCase("admin@gmail.com")) {
			return "adminHome";
		}else {
			return "userHome";
		}
		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	@GetMapping("map_home")
	public String firstHome() {
		return "index";
	}
}

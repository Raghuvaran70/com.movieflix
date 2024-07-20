package com.movieflix.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MovieUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String emailId;
	String password;
	String gender;
	String phoneNo;
	String address;
	boolean isPremium;
	public MovieUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieUser(int id, String name, String emailId, String password, String gender, String phoneNo,
			String address, boolean isPremium) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.address = address;
		this.isPremium = isPremium;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isPremium() {
		return isPremium;
	}
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	@Override
	public String toString() {
		return "MovieUser [id=" + id + ", name=" + name + ", emailId=" + emailId + ", password=" + password
				+ ", gender=" + gender + ", phoneNo=" + phoneNo + ", address=" + address + ", isPremium=" + isPremium
				+ "]";
	}
	
	
}

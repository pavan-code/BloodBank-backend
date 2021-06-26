package com.pavan.models;

import java.util.List;

public class AuthResponse {

	private String jwt;
	private int statusCode;
	private String message;
	private Donor donor;
	private List<Donor> donors;
	public AuthResponse() {

	}
	

	public AuthResponse(String jwt, int statusCode, String message, Donor donor, List<Donor> donors) {
		super();
		this.jwt = jwt;
		this.statusCode = statusCode;
		this.message = message;
		this.donor = donor;
		this.donors = donors;
	}


	public List<Donor> getDonors() {
		return donors;
	}


	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}


	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

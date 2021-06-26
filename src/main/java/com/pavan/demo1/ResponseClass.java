package com.pavan.demo1;

import com.pavan.models.Donor;

public class ResponseClass {
	private int statusCode;
	private String message;
	private String data;
	private Donor donor;
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
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ResponseClass(int statusCode, String message, String data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}
	public ResponseClass(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;		
	}
	
}

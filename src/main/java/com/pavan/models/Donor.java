package com.pavan.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String email;
	private long mobile;
	private String password;
	private String bloodGroup;
	private String gender;
	private Date dob;
	private int weight;
	private String state;
	private String district;
	private String city;
	private long pincode;
	private String roles = "ROLE_USER";

	public Donor() {

	}

	public Donor(int id, String username, String email, long mobile, String password, String bloodGroup, String gender,
			Date dob, int weight, String state, String district, String city, long pincode, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.dob = dob;
		this.weight = weight;
		this.state = state;
		this.district = district;
		this.city = city;
		this.pincode = pincode;
		this.roles = roles;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Donor(int id, String username, String email, long mobile, String password, String bloodGroup, String gender,
			Date dob, int weight, String state, String district, String city, long pincode) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.dob = dob;
		this.weight = weight;
		this.state = state;
		this.district = district;
		this.city = city;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "RegisterClass [id=" + id + ", username=" + username + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + ", bloodGroup=" + bloodGroup + ", gender=" + gender + ", dob=" + dob
				+ ", weight=" + weight + ", state=" + state + ", district=" + district + ", city=" + city + ", pincode="
				+ pincode + "]";
	}

}

package com.pavan.repo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pavan.models.Donor;

public class DonorDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String password;
	private String bloodGroup;
	private String gender;
	private Date dob;
	private int weight;
	private long mobileNumber;
	private String state;
	private String district;
	private String city;
	private long pincode;
	private List<GrantedAuthority> authorities;
	
	public DonorDetails(Donor model) {
		this.username = model.getUsername();
		this.email=model.getEmail();
		this.password=model.getPassword();
		this.bloodGroup=model.getBloodGroup();
		this.weight = model.getWeight();
		this.gender=model.getGender();
		this.dob=model.getDob();
		this.mobileNumber=model.getMobile();
		this.state=model.getState();
		this.district=model.getDistrict();
		this.city=model.getCity();
		this.pincode=model.getPincode();
		
		this.authorities=Arrays.stream(model.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}

package com.pavan.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pavan.models.Donor;
import com.pavan.repo.DonorDetails;
import com.pavan.repo.DonorRepo;

@Service
public class ProjectService implements UserDetailsService{
	
	@Autowired
	DonorRepo repo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Donor model=repo.findByEmail(email);
		if(model==null) {
			throw new UsernameNotFoundException("Not Found...");
		}
		return new DonorDetails(model);
	}

	public Donor Save(Donor Model) {
		System.out.println(Model.getDob());
		Model.setPassword(passwordEncoder.encode(Model.getPassword()));
	    Donor model= repo.save(Model);	
	    return model;
	}
	
//	public List<findDonorModel> find(String bloodGroup,String state,String district){
//		System.out.println(bloodGroup);
//		List<findDonorModel> l=repo.findByBloodGroupAndStateAndDistrict(bloodGroup,state,district);
//		System.out.println(l);
//		return l;
//	}
	public List<Donor> findBlood(String group) {
		List<Donor> donors = repo.findByBloodGroup(group);
		return donors;
	}

	public Donor findByEmail(String email) {
		Donor model=repo.findByEmail(email);
		return model;
	}
	
	public int count(String blood) {
		return repo.findByBloodGroup(blood).size();
	}
	public List<Donor> getDonors() {
		return repo.findAll();
	}
}

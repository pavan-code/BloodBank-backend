package com.pavan.demo1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.models.AuthRequest;
import com.pavan.models.AuthResponse;
import com.pavan.models.Donor;
import com.pavan.models.RequestBlood;
import com.pavan.repo.DonorRepo;
import com.pavan.repo.RequestRepo;

@CrossOrigin("*")
@RestController
public class Controller {

	@Autowired
	DonorRepo repo;

	@Autowired
	RequestRepo reqRepo;

	@Autowired
	ProjectService service;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtTokenUtil;

	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody Donor Model) {
		Donor model = service.Save(Model);
		if (model == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(new AuthResponse(null, 200, "Registered Successfully!", null, null));
		}
	}

	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest)
			throws Exception {
		System.out.println("authenticated");
		try {
			System.out.println(authenticationRequest.getEmail() + "  " + authenticationRequest.getPassword());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
					authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			return ResponseEntity.ok(new AuthResponse(null, 403, "Incorrect Username or Password", null, null));
		}
		final UserDetails userDetails = service.loadUserByUsername(authenticationRequest.getEmail());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		Donor donor = repo.findByEmail(authenticationRequest.getEmail());
		return ResponseEntity.ok(new AuthResponse(jwt, 200, "Login Successfull!", donor, null));
	}

	@GetMapping(value = "/findBlood/{group}", produces = "application/json")
	@CrossOrigin("*")
	public ResponseEntity<?> findBlood(@PathVariable("group") String group) {
		System.out.println(group);
		List<Donor> donors = service.findBlood(group);
		return ResponseEntity.ok(new AuthResponse(null, 200, "Donors by blood group", null, donors));
	}

	@GetMapping(value = "/bloodCount", produces = "application/json")
	public List<Integer> getCount() {
		List<Integer> count = new ArrayList<>();
		String[] bloods = { "A-", "A+", "AB-", "AB+", "B-", "B+", "O-", "O+" };
		for (int i = 0; i < 8; i++) {
			count.add(service.count(bloods[i]));
		}
		return count;
	}

	@GetMapping(value = "/donor", produces = "application/json")
	public ResponseEntity<?> getAllDonors() {
		List<Donor> donors = service.getDonors();
		return ResponseEntity.ok(new AuthResponse(null, 200, "All Donors List", null, donors));
	}

	@PostMapping("/requestBlood")
	public ResponseEntity<?> requestBlood(@RequestBody RequestBlood data) {
		System.out.println(data);
		reqRepo.save(data);
		return ResponseEntity.ok(new AuthResponse(null, 200, "Requested Blood Successfully", null, null));
	}

	@GetMapping("/getRequests")
	public List<RequestBlood> getRequests() {
		List<RequestBlood> list = reqRepo.findAll();
		return list;
	}

}

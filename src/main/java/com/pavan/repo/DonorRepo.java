package com.pavan.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pavan.models.Donor;

public interface DonorRepo extends JpaRepository<Donor, String>{

	Donor findByEmail(String email);
	
	List<Donor> findByBloodGroup(String group);
	
//	@Query(value="select * from projectModel p where p.bloodGroup=?0,p.state=?1,p.district=?2", nativeQuery = true)
//	List<findDonorModel> findByBloodGroupAndStateAndDistrict(String bloodGroup,String state,String district);
	
}

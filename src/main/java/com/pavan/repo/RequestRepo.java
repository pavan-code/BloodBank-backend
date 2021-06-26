package com.pavan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavan.models.RequestBlood;

public interface RequestRepo extends JpaRepository<RequestBlood, Integer> {

}

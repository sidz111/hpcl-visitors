package com.hpmhl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hpmhl.entities.GatePass;

@Repository
public interface GatePassRepository extends JpaRepository<GatePass, Integer>{

	GatePass findByGatePassNumber(String gatePassNumber);
	

}

package com.dee.FleetApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dee.FleetApp.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	public boolean existsByEmail(String email);
	
	public Admin findByEmail(String email);
}

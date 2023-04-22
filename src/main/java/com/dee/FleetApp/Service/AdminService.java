package com.dee.FleetApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dee.FleetApp.Model.Admin;
import com.dee.FleetApp.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void saveWithEncodedPassword(Admin admin) {
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin.setRole("ROLE_USER");
		adminRepository.save(admin);
	}
	
	public void saveNormal(Admin admin) {
		adminRepository.save(admin);
	}
	
	public boolean checkEmail(String email) {
		return adminRepository.existsByEmail(email);
	}
	
	public List<Admin> findAll(){
		return adminRepository.findAll();
	}
	
	public Optional<Admin> findById(int id){
		return adminRepository.findById(id);
	}
	
	public void delete(int id) {
		adminRepository.deleteById(id);
	}

}

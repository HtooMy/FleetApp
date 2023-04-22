package com.dee.FleetApp.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dee.FleetApp.Model.Admin;
import com.dee.FleetApp.Repository.AdminRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByEmail(email);
		if(admin != null) {
			System.out.println("Email is found and userDetailsServiceImpl Success");
			return new CustomUserDetails(admin);
		}
		throw new UsernameNotFoundException("User is not available");
	}

}

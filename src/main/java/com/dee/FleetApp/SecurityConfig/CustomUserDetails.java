package com.dee.FleetApp.SecurityConfig;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dee.FleetApp.Model.Admin;

public class CustomUserDetails implements UserDetails{

	private Admin admin;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(admin.getRole());
		return Arrays.asList(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return admin.getFullName();
	}
	
	public int getId() {
		// TODO Auto-generated method stub
		return admin.getId();
	}
	
	public String getRole() {
		// TODO Auto-generated method stub
		return admin.getRole();
	}
	
	public String getBirthday() {
		// TODO Auto-generated method stub
		return admin.getBirthday();
	}
	
	public String getOccupation() {
		// TODO Auto-generated method stub
		return admin.getOccupation();
	}
	
	public String getAboutMe() {
		// TODO Auto-generated method stub
		return admin.getAboutMe();
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return admin.getEmail();
	}
	
	public String getMobile() {
		// TODO Auto-generated method stub
		return admin.getMobile();
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

	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public CustomUserDetails(Admin admin) {
		super();
		this.admin = admin;
	}
	
	

}

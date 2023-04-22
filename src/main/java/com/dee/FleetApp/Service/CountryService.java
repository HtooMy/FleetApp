package com.dee.FleetApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dee.FleetApp.Model.Country;
import com.dee.FleetApp.Repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}
	
	public List<Country> findAll(){
		return countryRepository.findAll();
	}
	
	public Optional<Country> findById(int id){
		return countryRepository.findById(id);
	}
	
	public void deleteCountry(int id) {
		countryRepository.deleteById(id);
	}
}

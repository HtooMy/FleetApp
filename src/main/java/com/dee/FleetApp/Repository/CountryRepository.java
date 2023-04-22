package com.dee.FleetApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dee.FleetApp.Model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}

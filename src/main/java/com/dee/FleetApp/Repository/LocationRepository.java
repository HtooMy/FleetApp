package com.dee.FleetApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dee.FleetApp.Model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}


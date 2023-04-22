package com.dee.FleetApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dee.FleetApp.Model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}

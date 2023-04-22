package com.dee.FleetApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dee.FleetApp.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}

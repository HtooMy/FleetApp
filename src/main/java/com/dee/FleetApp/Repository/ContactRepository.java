package com.dee.FleetApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dee.FleetApp.Model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}

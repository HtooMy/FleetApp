package com.dee.FleetApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dee.FleetApp.Model.State;
import com.dee.FleetApp.Repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	public void saveState(State state) {
		stateRepository.save(state);
	}
	
	public List<State> findAll(){
		return stateRepository.findAll();
	}
	
	public Optional<State> findById(int id){
		return stateRepository.findById(id);
	}
	
	public void deleteState(int id) {
		stateRepository.deleteById(id);
	}
}

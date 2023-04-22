package com.dee.FleetApp.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dee.FleetApp.Model.State;
import com.dee.FleetApp.Service.CountryService;
import com.dee.FleetApp.Service.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/state")
	public String findAll(Model model) {
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "state";
	}
	
	@PostMapping("/state/add-new")
	public String addNew(State State) {
		stateService.saveState(State);
		return "redirect:/state";
	}
	
	@RequestMapping("state/findById") 
	@ResponseBody
	public Optional<State> findById(int id) {
		return stateService.findById(id);
	}
	
	@RequestMapping(value="state/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(State State) {
		stateService.saveState(State);
		return "redirect:/state";
	}
	
	@RequestMapping(value="state/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		stateService.deleteState(id);
		return "redirect:/state";
	}
}

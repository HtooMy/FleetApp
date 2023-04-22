package com.dee.FleetApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dee.FleetApp.Model.Location;
import com.dee.FleetApp.Service.CountryService;
import com.dee.FleetApp.Service.LocationService;
import com.dee.FleetApp.Service.StateService;

@Controller
public class LocationController {

	@Autowired	private LocationService locationService;
	@Autowired	private CountryService countryService;
	@Autowired	private StateService stateService;
	
	@GetMapping("/location")
	public String findAll(Model model){
		model.addAttribute("locations", locationService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		return "location";
	}
	
	@GetMapping("location/findById")
	@ResponseBody
	public Optional<Location> findById(Integer id) {
		return locationService.findById(id);
	}		
	
	@GetMapping("location/findByDescriptionContaining/{description}")
	public List<Location> findByDescriptionContaining(@PathVariable("description") String description) {
		return locationService.findByDescriptionContaining(description);
	}

	@PostMapping("location/add-new")
	public String save(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}

	@RequestMapping(value="location/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	
	@RequestMapping(value="location/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String deleteById(Integer id) {
		locationService.deleteById(id);
		return "redirect:/location";
	}
	
}
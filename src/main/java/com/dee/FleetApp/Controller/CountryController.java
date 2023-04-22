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

import com.dee.FleetApp.Model.Country;
import com.dee.FleetApp.Service.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/country")
	public String findAll(Model model) {
		model.addAttribute("countries", countryService.findAll());
		return "country";
	}
	
	@PostMapping("/country/add-new")
	public String addNew(Country country) {
		countryService.saveCountry(country);
		return "redirect:/country";
	}
	
	@RequestMapping("country/findById") 
	@ResponseBody
	public Optional<Country> findById(int id) {
		return countryService.findById(id);
	}
	
	@RequestMapping(value="country/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.saveCountry(country);
		return "redirect:/country";
	}
	
	@RequestMapping(value="country/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		countryService.deleteCountry(id);
		return "redirect:/country";
	}
}

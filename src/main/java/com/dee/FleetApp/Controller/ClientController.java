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

import com.dee.FleetApp.Model.Client;
import com.dee.FleetApp.Service.ClientService;
import com.dee.FleetApp.Service.CountryService;
import com.dee.FleetApp.Service.StateService;

@Controller
public class ClientController {
	
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;	
	@Autowired private ClientService clientService;
	
	//Get All Clients
	@GetMapping("/client")
	public String findAll(Model model){		
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("clients", clientService.findAll());
		return "client";
	}	
	
	@RequestMapping("client/findById") 
	@ResponseBody
	public Optional<Client> findById(Integer id)
	{
		return clientService.findById(id);
	}
	
	//Add Client
	@PostMapping(value="client/addNew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}	
	
	@RequestMapping(value="client/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}
	
	@RequestMapping(value="client/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		clientService.delete(id);
		return "redirect:/client";
	}

}


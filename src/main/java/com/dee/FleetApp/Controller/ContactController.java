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

import com.dee.FleetApp.Model.Contact;
import com.dee.FleetApp.Service.ContactService;
import com.dee.FleetApp.Service.CountryService;
import com.dee.FleetApp.Service.StateService;

@Controller
public class ContactController {
	
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;	
	@Autowired private ContactService contactService;
	
	//Get All Contacts
	@GetMapping("/contact")
	public String findAll(Model model){		
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("contacts", contactService.findAll());
		return "contact";
	}	
	
	@RequestMapping("contact/findById") 
	@ResponseBody
	public Optional<Contact> findById(Integer id)
	{
		return contactService.findById(id);
	}
	
	//Add Contact
	@PostMapping(value="contact/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}	
	
	@RequestMapping(value="contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	@RequestMapping(value="contact/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/contact";
	}

}

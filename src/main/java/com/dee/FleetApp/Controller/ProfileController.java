package com.dee.FleetApp.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dee.FleetApp.Service.EmployeeService;

@Controller
public class ProfileController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/profile")
	public String profile(Model model, Principal principal) {
		String un = principal.getName();
		model.addAttribute("employee", employeeService.findByUsername(un));
		return "profile";
	}
}

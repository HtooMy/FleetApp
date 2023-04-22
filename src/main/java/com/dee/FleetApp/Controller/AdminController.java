package com.dee.FleetApp.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dee.FleetApp.Model.Admin;
import com.dee.FleetApp.Service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register-new")
	public String createAdmin(@ModelAttribute Admin admin) {
		boolean yes = adminService.checkEmail(admin.getEmail());
		if (yes) {
			System.out.println("Error");
		} else {
			adminService.saveWithEncodedPassword(admin);
			System.out.println("Success Controller");
		}
		return "login";
	}
	
	@PostMapping("/user-role/addNew")
	public String createAdminInPage(@ModelAttribute Admin admin) {
		boolean yes = adminService.checkEmail(admin.getEmail());
		if (yes) {
			System.out.println("Error");
		} else {
			adminService.saveWithEncodedPassword(admin);
			System.out.println("Success Controller");
		}
		return "redirect:/user-role";
	}
	
	@GetMapping("/user-role")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String findAll(Model model) {
		model.addAttribute("users", adminService.findAll());
		return "user-role";
	}
	
	@RequestMapping("user-role/findById") 
	@ResponseBody
	public Optional<Admin> findById(int id) {
		return adminService.findById(id);
	}
	
	@RequestMapping(value="user-role/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Admin admin) {
		adminService.saveNormal(admin);
		return "redirect:/user-role";
	}
	
	@RequestMapping(value="user-role/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		adminService.delete(id);
		return "redirect:/user-role";
	}
	
	@RequestMapping(value="/profile/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateProfile(@ModelAttribute("admin") Admin admin, @RequestParam("id") int id) {
	admin.setId(id);
	adminService.saveNormal(admin);
	return "redirect:/profile";
	}
}

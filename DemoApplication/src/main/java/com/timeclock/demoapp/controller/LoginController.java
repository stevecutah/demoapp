package com.timeclock.demoapp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.timeclock.demoapp.model.TimeclockUser;
import com.timeclock.demoapp.service.LoginService;

@Controller
@SessionAttributes("timeclockUser")
public class LoginController {


	
	@Autowired
	private LoginService	loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void getLoginForm(Model model) {
		model.addAttribute("timeclockUser", new TimeclockUser());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("timeclockUser") TimeclockUser timeclockUser, BindingResult result, Model model) {
		
		String navigationAction = "login";

		try {
			timeclockUser = loginService.login(timeclockUser);
			model.addAttribute("timeclockUser", timeclockUser);
			navigationAction = "redirect:dashboard.html";
		}
		catch (NullPointerException npex) {
			if(result.hasErrors() ==false) {
				result.rejectValue("emailAddress", "login.error.emailAddress_notfound", null, null);
			}
		}

		return navigationAction;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String doLogout(@ModelAttribute("timeclockUser") TimeclockUser timeclockUser, Model model, HttpSession session, BindingResult result) {
		session.removeAttribute("timeclockUser");
		model.addAttribute("timeclockUser", new TimeclockUser());
		model.addAttribute("logoutMessage", "You have successfully logged out");
		return "logout";
	}	
	
	@RequestMapping(value="/logout", method = RequestMethod.POST) 
	public String getLoginForm(@Valid @ModelAttribute("timeclockUser") TimeclockUser timeclockUser, BindingResult result, Model model) {
		return this.doLogin(timeclockUser, result, model);
	}
	
	
	@ModelAttribute("timeclockUser")
	public TimeclockUser getTimeclockUser() {
		return new TimeclockUser();
	}
}

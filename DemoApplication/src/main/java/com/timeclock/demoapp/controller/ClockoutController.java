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
import com.timeclock.demoapp.enumeration.EventType;
import com.timeclock.demoapp.model.TimeclockEvent;
import com.timeclock.demoapp.model.TimeclockUser;
import com.timeclock.demoapp.service.EventService;

@Controller
@SessionAttributes("timeclockEvent")
public class ClockoutController {
	
	@Autowired
	private EventService eventService;

	@RequestMapping(value="/clockout", method = RequestMethod.GET)
	public void getClockinForm(Model model, HttpSession session) {
		TimeclockUser timeclockUser = (TimeclockUser)session.getAttribute("timeclockUser");
		TimeclockEvent timeclockEvent = timeclockUser.getNewTimeclockEvent();
		timeclockEvent.setEventType(EventType.CLOCKOUT.getEventTypeDescription());
		model.addAttribute("timeclockEvent", timeclockEvent);
	}
	
	@RequestMapping(value = "/clockout", method = RequestMethod.POST)
	public String doClocin(@Valid @ModelAttribute("timeclockEvent") TimeclockEvent timeclockEvent, BindingResult result, HttpSession session, Model model) {
		String navigationAction = "clockout";
		try {
			TimeclockUser timeclockUser = getTimeclockUser(session);
			timeclockUser.getTimeClockEvents().clear();
			timeclockUser.getTimeClockEvents().add(timeclockEvent);
			timeclockUser = eventService.doEvent(timeclockUser);
			navigationAction = "redirect:dashboard.html";
		} catch(NullPointerException npex) {
			navigationAction = "clockout";
		}
		
		return navigationAction;
	}
	
	private TimeclockUser getTimeclockUser(HttpSession session) {
		return (TimeclockUser)session.getAttribute("timeclockUser");
	}
}

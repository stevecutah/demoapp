package com.timeclock.demoapp.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.timeclock.demoapp.enumeration.EventType;
import com.timeclock.demoapp.model.TimeclockEvent;
import com.timeclock.demoapp.model.TimeclockUser;
import com.timeclock.demoapp.service.DashboardService;

@Controller
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;	
	
	@RequestMapping(value = "/dashboard")
	public String getDashboard(Model model, HttpSession session, TimeclockEvent timeclockEvent) {
		String navigationAction = "";
				
		try {
			timeclockEvent = dashboardService.getLastestEvent(timeclockEvent, (TimeclockUser)session.getAttribute("timeclockUser"));
			if(timeclockEvent.getEventType().equals(EventType.CLOCKIN.getEventTypeDescription())) {
				navigationAction = "redirect:"+EventType.CLOCKOUT.getEventTypeDescription()+".html";
			} else {
				navigationAction = "redirect:"+EventType.CLOCKIN.getEventTypeDescription()+".html";
			}
		} catch(NullPointerException npex) {
			navigationAction = "redirect:"+EventType.CLOCKIN.getEventTypeDescription()+".html";
		}
		return navigationAction;
	}
}

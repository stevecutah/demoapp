package com.timeclock.demoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.timeclock.demoapp.model.TimeclockEvent;
import com.timeclock.demoapp.model.TimeclockUser;
import com.timeclock.demoapp.respository.DashboardRepository;

@Service("dashboardService")
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	DashboardRepository dashboardRepository;
	
	public TimeclockEvent getLastestEvent(TimeclockEvent timeclockEvent, TimeclockUser timeclockUser) throws NullPointerException {
		
		if(timeclockUser.getTimeClockEvents().isEmpty() ==false) {
			// I know that this will be the latest time clock event due to the order by annotation on the object in timeclockUser
			timeclockEvent = timeclockUser.getTimeClockEvents().get(0); 
		} else {
			throw new NullPointerException();
		}
		return timeclockEvent;
	}

}

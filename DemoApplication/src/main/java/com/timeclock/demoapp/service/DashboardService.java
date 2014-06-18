package com.timeclock.demoapp.service;

import com.timeclock.demoapp.model.TimeclockEvent;
import com.timeclock.demoapp.model.TimeclockUser;

public interface DashboardService {
	public TimeclockEvent getLastestEvent(TimeclockEvent timeclockEvent, TimeclockUser timeclockUser) throws NullPointerException;
}

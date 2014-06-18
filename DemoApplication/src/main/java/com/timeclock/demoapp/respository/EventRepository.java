package com.timeclock.demoapp.respository;

import com.timeclock.demoapp.model.TimeclockUser;

public interface EventRepository {
	public TimeclockUser doEvent(TimeclockUser timeclockUser);
}

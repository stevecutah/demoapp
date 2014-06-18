package com.timeclock.demoapp.service;

import com.timeclock.demoapp.model.TimeclockUser;

public interface LoginService {
	TimeclockUser login(TimeclockUser timeclockUser) throws NullPointerException;
}

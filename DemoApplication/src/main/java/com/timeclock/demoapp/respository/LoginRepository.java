package com.timeclock.demoapp.respository;

import java.util.List;
import com.timeclock.demoapp.model.TimeclockUser;

public interface LoginRepository {

	List<TimeclockUser> login(TimeclockUser timeclockUser) throws NullPointerException;
}

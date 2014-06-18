package com.timeclock.demoapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.timeclock.demoapp.model.TimeclockUser;
import com.timeclock.demoapp.respository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository	loginRepository;

	public TimeclockUser login(TimeclockUser timeclockUser) throws NullPointerException {

		List<TimeclockUser> timeclockUsers = loginRepository.login(timeclockUser);

		if (timeclockUsers.isEmpty() == false) {
			timeclockUser = timeclockUsers.get(0);
		} else {
			throw new NullPointerException();
		}

		return timeclockUser;
	}

}

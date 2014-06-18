package com.timeclock.demoapp.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.timeclock.demoapp.model.TimeclockUser;
import com.timeclock.demoapp.respository.EventRepository;

@Service("eventService")
public class EventServiceImpl implements EventService {
	@Autowired	
	private EventRepository eventRepository;
	
	@Transactional
	public TimeclockUser doEvent(TimeclockUser timeclockUser) {
		return eventRepository.doEvent(timeclockUser);
	}

}

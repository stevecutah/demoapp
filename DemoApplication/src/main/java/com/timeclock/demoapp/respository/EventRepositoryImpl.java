package com.timeclock.demoapp.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.timeclock.demoapp.model.TimeclockUser;

@Repository("eventRepository")
public class EventRepositoryImpl implements EventRepository {

	@PersistenceContext
	private EntityManager entityManager;	

	public TimeclockUser doEvent(TimeclockUser timeclockUser) {
		entityManager.merge(timeclockUser);
		entityManager.flush();
		return timeclockUser;
	}

}

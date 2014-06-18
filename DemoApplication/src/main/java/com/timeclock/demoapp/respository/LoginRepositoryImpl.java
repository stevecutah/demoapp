package com.timeclock.demoapp.respository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.timeclock.demoapp.model.TimeclockUser;

@Repository("loginRepository")
public class LoginRepositoryImpl implements LoginRepository {

	@PersistenceContext
	private EntityManager	entityManager;

	public List<TimeclockUser> login(TimeclockUser timeclockUser) throws NullPointerException {

		return entityManager.createNamedQuery("timeclockuser.login", TimeclockUser.class)
				.setParameter("emailAddress", timeclockUser.getEmailAddress())
				.getResultList();

	}

}

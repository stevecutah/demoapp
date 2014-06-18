package com.timeclock.demoapp.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("dashboardRepository")
public class DashboardRepositoryImpl implements DashboardRepository {

	@PersistenceContext
	private EntityManager entityManager;	

}

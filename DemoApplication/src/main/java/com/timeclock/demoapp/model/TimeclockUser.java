package com.timeclock.demoapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(schema = "public", name = "Timeclock_User")
@NamedQuery(name = "timeclockuser.login", query = "Select user From TimeclockUser user Where user.emailAddress=:emailAddress")
public class TimeclockUser {

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = "timeclock_user_seq", sequenceName = "timeclock_user_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeclock_user_seq")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_address")
	@Length(min=6, max=256)
	private String emailAddress;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "timeclock_user_id")
	@OrderBy("id DESC")
	private List<TimeclockEvent> timeClockEvents = new ArrayList<TimeclockEvent>();
	
	private static final String objectName = "timeclockUser";

	public static String getObjectname() {
		return objectName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public List<TimeclockEvent> getTimeClockEvents() {
		return timeClockEvents;
	}

	public boolean isAuthenticated() {
		if(this.id != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public TimeclockEvent getNewTimeclockEvent() {
		TimeclockEvent timeclockEvent = new TimeclockEvent();
		timeclockEvent.setTimeclockUserId(this.id);
		timeclockEvent.setEventDate(new java.sql.Date((new Date()).getTime()));
		return timeclockEvent;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setTimeClockEvents(List<TimeclockEvent> timeClockEvents) {
		this.timeClockEvents = timeClockEvents;
	}

}

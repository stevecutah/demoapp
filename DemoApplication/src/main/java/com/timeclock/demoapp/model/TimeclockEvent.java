package com.timeclock.demoapp.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "Timeclock_Event")
public class TimeclockEvent {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "timeclock_entry_seq", sequenceName = "timeclock_entry_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeclock_entry_seq")
	private int id;

	@Column(name = "timeclock_user_id")
	private int timeclockUserId;

	@Column(name = "event_date")
	@DateTimeFormat(pattern="HH:mm:ss dd MMMM yyyy")
	private Date eventDate;
	

	@Column(name = "event_notes")
	private String eventNotes;
	
	@Column(name="event_type")
	private String eventType;
	
	private static final String objectName = "timeclockEvent";

	public static String getObjectname() {
		return objectName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public String getEventNotes() {
		return eventNotes;
	}

	public String getEventType() {
		return eventType;
	}

	public int getId() {
		return id;
	}

	public int getTimeclockUserId() {
		return timeclockUserId;
	}


	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public void setEventNotes(String eventNotes) {
		this.eventNotes = eventNotes;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTimeclockUserId(int timeclockUserId) {
		this.timeclockUserId = timeclockUserId;
	}

}

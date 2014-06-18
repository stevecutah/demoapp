package com.timeclock.demoapp.enumeration;

public enum EventType {
	CLOCKIN("clockin"), 
	CLOCKOUT("clockout");
	
	private String eventTypeDescription;
	
	EventType(String eventTypeDescription) {
		this.eventTypeDescription = eventTypeDescription;
	}

	public String getEventTypeDescription() {
		return eventTypeDescription;
	}
	
	
}

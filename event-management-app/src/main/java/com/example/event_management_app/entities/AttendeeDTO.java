package com.example.event_management_app.entities;

public class AttendeeDTO {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Long eventId;
	
	private String eventTitle;
	
	private String eventDate;
	
	public AttendeeDTO(Long id, String name, String email, Long eventId, String eventTitle, String eventDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
}

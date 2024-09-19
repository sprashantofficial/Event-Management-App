package com.example.event_management_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event_management_app.entities.Event;
import com.example.event_management_app.repo.EventRepo;

@Service
public class EventService {
	
	@Autowired
	private EventRepo eventRepo;
	
	public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    public Event createEvent(Event event) {
        return eventRepo.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
    	Optional.ofNullable(eventDetails)
        .orElseThrow(() -> new RuntimeException("Event details must not be null"));

        eventDetails.setId(id);

        return eventRepo.save(eventDetails);
    }

    public void deleteEvent(Long id) {
        Event existingEvent = getEventById(id);
        if (existingEvent != null) {
        	eventRepo.delete(existingEvent);
        } else {
        	throw new RuntimeException("Couldn't find an event with the given id");
        }
        
    }

}

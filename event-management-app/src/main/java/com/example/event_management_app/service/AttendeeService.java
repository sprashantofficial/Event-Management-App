package com.example.event_management_app.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event_management_app.entities.Attendee;
import com.example.event_management_app.entities.AttendeeDTO;
import com.example.event_management_app.entities.Event;
import com.example.event_management_app.repo.AttendeeRepo;
import com.example.event_management_app.repo.EventRepo;

@Service
public class AttendeeService {

	@Autowired
	private AttendeeRepo attendeeRepo;

	@Autowired
	private EventRepo eventRepo;

	public List<Attendee> getAllAttendees() {
		return attendeeRepo.findAll();
	}

	public Attendee getAttendeeById(Long id) {
		return attendeeRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Couldn't find attendee with given id"));
	}

	public AttendeeDTO createAttendee(Long eventId, Attendee attendee) {
		Optional<Event> eventObj = eventRepo.findById(eventId);
		if (eventObj.isPresent()) {
			Event event = eventObj.get();
			attendee.setEvent(event);

			Attendee savedAttendee = attendeeRepo.save(attendee);

			String eventDate = event.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);

			return new AttendeeDTO(savedAttendee.getId(), savedAttendee.getName(), savedAttendee.getEmail(),
					event.getId(), event.getTitle(), eventDate);
		} else {
			throw new RuntimeException("Event not found with the given id");
		}
	}
	
	public void deleteAttendee(Long id) {
		attendeeRepo.deleteById(id);
	}

}

package com.example.event_management_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.event_management_app.entities.Event;
import com.example.event_management_app.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/events")
public class EventController {
	
	@Autowired
	private EventService eventService;

	@GetMapping
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id) {
		Optional<Event> event = Optional.ofNullable(eventService.getEventById(id));
		return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Event createEvent(@Valid @RequestBody Event event) {
		return eventService.createEvent(event);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
		Event updatedEvent = eventService.updateEvent(id, eventDetails);
		return ResponseEntity.ok(updatedEvent);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
	}

}

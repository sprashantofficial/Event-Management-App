package com.example.event_management_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event_management_app.entities.Attendee;
import com.example.event_management_app.entities.AttendeeDTO;
import com.example.event_management_app.service.AttendeeService;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

	@Autowired
	private AttendeeService attendeeService;

	@GetMapping
	public List<Attendee> getAllAttendees() {
		return attendeeService.getAllAttendees();
	}

	@GetMapping("/{id}")
	public Attendee getAttendeeById(@PathVariable Long id) {
		return attendeeService.getAttendeeById(id);
	}

	@PostMapping("/event/{eventId}")
	public ResponseEntity<AttendeeDTO> createAttendee(@PathVariable Long eventId, @RequestBody Attendee attendee) {
		AttendeeDTO createdAttendee = attendeeService.createAttendee(eventId, attendee);
		return ResponseEntity.ok(createdAttendee);
	}

	@DeleteMapping("/{id}")
	public void deleteAttendee(@PathVariable Long id) {
		attendeeService.deleteAttendee(id);
	}

}

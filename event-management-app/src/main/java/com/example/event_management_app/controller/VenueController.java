package com.example.event_management_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event_management_app.entities.Venue;
import com.example.event_management_app.service.VenueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

	@Autowired
    private VenueService venueService;

    // Get all venues
    @GetMapping
    public ResponseEntity<List<Venue>> getAllVenues() {
        List<Venue> venues = venueService.getAllVenues();
        return ResponseEntity.ok(venues);
    }

    // Get a venue by ID
    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        Venue venue = venueService.getVenueById(id);
        return ResponseEntity.ok(venue);
    }

    // Create a new venue
    @PostMapping
    public ResponseEntity<Venue> createVenue(@Valid @RequestBody Venue venue) {
        Venue createdVenue = venueService.createVenue(venue);
        return ResponseEntity.ok(createdVenue);
    }

    // Update an existing venue
    @PutMapping("/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @Valid @RequestBody Venue venueDetails) {
        Venue updatedVenue = venueService.updateVenue(id, venueDetails);
        return ResponseEntity.ok(updatedVenue);
    }

    // Delete a venue
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
        return ResponseEntity.noContent().build();
    }
}


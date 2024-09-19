package com.example.event_management_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event_management_app.entities.Venue;
import com.example.event_management_app.repo.VenueRepo;

@Service
public class VenueService {
	
	@Autowired
	private VenueRepo venueRepo;
	
	public List<Venue> getAllVenues() {
        return venueRepo.findAll();
    }

    // Get a venue by ID
    public Venue getVenueById(Long id) {
        return venueRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id " + id));
    }

    // Create a new venue
    public Venue createVenue(Venue venue) {
        return venueRepo.save(venue);
    }

    // Update an existing venue
    public Venue updateVenue(Long id, Venue venueDetails) {
        Venue existingVenue = venueRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id " + id));

        // Update the venue details
        existingVenue.setName(venueDetails.getName());
        existingVenue.setLocation(venueDetails.getLocation());

        return venueRepo.save(existingVenue);
    }

    // Delete a venue
    public void deleteVenue(Long id) {
        Venue existingVenue = venueRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id " + id));
        venueRepo.delete(existingVenue);
    }

}

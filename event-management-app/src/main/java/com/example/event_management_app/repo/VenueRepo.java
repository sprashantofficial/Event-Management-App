package com.example.event_management_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event_management_app.entities.Venue;

public interface VenueRepo extends JpaRepository<Venue, Long> {

}

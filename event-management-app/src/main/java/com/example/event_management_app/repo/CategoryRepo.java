package com.example.event_management_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event_management_app.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}

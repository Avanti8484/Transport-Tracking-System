package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip,  Integer>{

}

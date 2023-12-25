package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Trip;
import com.example.repository.TripRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TripController {
	
	@Autowired
	private TripRepository tripRepository;
	
	// Get All Trips Details
	@GetMapping("/trips")
	private List<Trip> getAllTrips()
	{
		return tripRepository.findAll();
	}
	
	@PostMapping("/trips")
	private Trip createTrip(@RequestBody Trip trip)
	{
		return tripRepository.save(trip);
	}

}

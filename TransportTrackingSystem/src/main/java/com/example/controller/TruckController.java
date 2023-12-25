package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourseNotFoundException;
import com.example.model.Truck;
import com.example.repository.TruckRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class TruckController {

	@Autowired
	
	
	 private TruckRepository truckRepository;
	
	//get All Truck Details
	@GetMapping("/trucks")
	public List<Truck> getAllTrucks()
	{
		return truckRepository.findAll();
	}
	
	//Create Truck rest Api
	@PostMapping("/trucks")
	public Truck createTruck(@RequestBody Truck truck)
	{
	   return truckRepository.save(truck);
	}
	
	//get truck by vehicleNo
	@GetMapping("/trucks/{vehicle_no}")
	public ResponseEntity< Truck> getTruckByVehicle_no(@PathVariable  String vehicle_no)
	{
		Truck truck = truckRepository.findById(vehicle_no).orElseThrow(()  -> new ResourseNotFoundException("Truck Not exist with Vehicle No: "+vehicle_no));
		return ResponseEntity.ok(truck);
	}
	
	//UPDATE TRUCK
	@PutMapping("/trucks/{vehicle_no}")
	public ResponseEntity<Truck> updateTruck(@PathVariable String vehicle_no,@RequestBody Truck truckDetails)
	{
		Truck truck = truckRepository.findById(vehicle_no)
				.orElseThrow(()  -> new ResourseNotFoundException("Truck Not exist with Vehicle No: "+vehicle_no));
		
		truck.setVehicle_no(truckDetails.getVehicle_no());
		truck.setModel(truckDetails.getModel());
		truck.setFuel_efficiency(truckDetails.getFuel_efficiency());
		
		Truck updatedTruck = truckRepository.save(truck);
		return ResponseEntity.ok(updatedTruck);
	}
	
	// Delete Truck
	@DeleteMapping("/trucks/{vehicle_no}")
	public ResponseEntity<Map<String, Boolean >>deleteTruck(@PathVariable String vehicle_no)
	{
		Truck truck = truckRepository.findById(vehicle_no)
				.orElseThrow(()  -> new ResourseNotFoundException("Truck Not exist with Vehicle No: "+vehicle_no));
		
		truckRepository.delete(truck);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
}

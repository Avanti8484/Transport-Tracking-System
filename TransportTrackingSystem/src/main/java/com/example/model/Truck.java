 package com.example.model;


 import jakarta.persistence.Table;

import java.util.List;
import java.util.Set;


import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



@Entity
@Table
public class Truck {

	@Id
	@NotNull
	@NotEmpty(message = "Vehicle No can't be empty!")
	@Size( max = 10, message = "Please enter proper name")
	@Pattern(regexp = "\\d|[a-zA-Z]")
	private String vehicle_no;
	@NotEmpty(message = "You can't keep Model Empty ")
	private String model;
	@NotEmpty(message = "You can't keep Fuel_efficiency Empty ")
	private String fuel_efficiency;
	@JsonIgnore
	@OneToMany( mappedBy="truck")
	private List<Trip> trips;
	
	public Truck()
	{
		
	}
	public Truck(String vehicle_no,String model, String fuel_efficiency) {
		super();
		this.vehicle_no=vehicle_no;
		this.model = model;
		this.fuel_efficiency = fuel_efficiency;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFuel_efficiency() {
		return fuel_efficiency;
	}
	public void setFuel_efficiency(String fuel_efficiency) {
		this.fuel_efficiency = fuel_efficiency;
	}
	
}

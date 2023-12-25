package com.example.model;

import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Trip {
	@Id
    @GeneratedValue(strategy =GenerationType.AUTO)

	private  int trip_no;
	private Date trip_date;
	private String o_location;
	private String fuel_filled;
	private String fuel_price;
   
    @ManyToOne
    @JoinColumn(name="vehicle_no")
    private Truck truck;
    public Trip()
    {
    	
    }
    

	public Trip(int trip_no, Date trip_date, String o_location, String fuel_filled, String fuel_price, Truck truck) {
		super();
		this.trip_no = trip_no;
		this.trip_date = trip_date;
		this.o_location = o_location;
		this.fuel_filled = fuel_filled;
		this.fuel_price = fuel_price;
		this.truck = truck;
	}

	public int getTrip_no() {
		return trip_no;
	}

	public void setTrip_no(int trip_no) {
		this.trip_no = trip_no;
	}

	public Date getTrip_date() {
		return trip_date;
	}

	public void setTrip_date(Date trip_date) {
		this.trip_date = trip_date;
	}

	public String getO_location() {
		return o_location;
	}

	public void setO_location(String o_location) {
		this.o_location = o_location;
	}

	public String getFuel_filled() {
		return fuel_filled;
	}

	public void setFuel_filled(String fuel_filled) {
		this.fuel_filled = fuel_filled;
	}

	public String getFuel_price() {
		return fuel_price;
	}

	public void setFuel_price(String fuel_price) {
		this.fuel_price = fuel_price;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}
    
   
}

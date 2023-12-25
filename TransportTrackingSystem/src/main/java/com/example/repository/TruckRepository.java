package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Truck;
@Repository
public interface TruckRepository extends JpaRepository<Truck ,  String> {

}

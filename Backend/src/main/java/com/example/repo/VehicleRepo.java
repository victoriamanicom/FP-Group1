package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data.VehicleRegistration;

public interface VehicleRepo extends JpaRepository<VehicleRegistration, Integer> {

}

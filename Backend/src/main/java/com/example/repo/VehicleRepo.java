package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.DTO.VehicleDTO;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleDTO, Long> {

}
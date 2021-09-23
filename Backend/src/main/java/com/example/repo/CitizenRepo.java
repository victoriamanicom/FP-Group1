package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.DTO.CitizenReturnDTO;

@Repository
public interface CitizenRepo extends JpaRepository<CitizenReturnDTO, Long> {

}

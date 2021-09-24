package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.DTO.WhereaboutsDTO;

@Repository
public interface WhereaboutsRepo extends JpaRepository<WhereaboutsDTO, Long> {

}
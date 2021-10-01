package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, String> {

}

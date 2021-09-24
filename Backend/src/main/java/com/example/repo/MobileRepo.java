package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.DTO.PeopleMobileDTO;

@Repository
public interface MobileRepo extends JpaRepository<PeopleMobileDTO, Long> {

}

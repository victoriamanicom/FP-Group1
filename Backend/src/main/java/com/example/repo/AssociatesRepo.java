package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.DTO.AssociatesDTO;

@Repository
public interface AssociatesRepo extends JpaRepository<AssociatesDTO, Long> {

}

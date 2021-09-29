package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.PeopleMobile;

@Repository
public interface PeopleMobileRepo extends JpaRepository<PeopleMobile, Integer> {

}
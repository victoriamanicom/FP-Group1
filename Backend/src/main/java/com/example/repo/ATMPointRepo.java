package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.ATMPoint;

@Repository
public interface ATMPointRepo extends JpaRepository<ATMPoint, Integer> {

}

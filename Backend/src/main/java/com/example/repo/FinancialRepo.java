package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.DTO.PeopleBankAccountDTO;

@Repository
public interface FinancialRepo extends JpaRepository<PeopleBankAccountDTO, Long> {

}
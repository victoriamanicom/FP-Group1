package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.BankCard;

@Repository
public interface BankCardRepo extends JpaRepository<BankCard, Integer> {

}

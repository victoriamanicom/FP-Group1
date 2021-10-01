package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.PeopleBankAccount;

@Repository
public interface PeopleBankAccountRepo extends JpaRepository<PeopleBankAccount, Integer> {

}

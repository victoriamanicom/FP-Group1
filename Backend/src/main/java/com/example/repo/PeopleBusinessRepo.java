package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.PeopleBusinessAddress;

@Repository
public interface PeopleBusinessRepo extends JpaRepository<PeopleBusinessAddress, Integer> {

}

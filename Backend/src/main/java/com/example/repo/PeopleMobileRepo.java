package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.PeopleMobile;

@Repository
public interface PeopleMobileRepo extends JpaRepository<PeopleMobile, String> {

	List<PeopleMobile> findByForenamesAndSurnameAndPostcode(String forenames, String Surname, String Postcode);

}
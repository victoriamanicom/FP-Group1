package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.Citizen;
import com.example.data.MobileCallRecords;
import com.example.data.PeopleMobile;

@Repository
public interface PeopleMobileRepo extends JpaRepository<PeopleMobile, Integer> {

	PeopleMobile findPeopleMobile(Citizen citizen);

	List<MobileCallRecords> findByReceiverMSISDN(String ReveiverMSISDN);

}
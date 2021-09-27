package com.example.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.Citizen;
import com.example.data.MobileCallRecords;
import com.example.data.PeopleBankAccount;
import com.example.data.PeopleMobile;
import com.example.rest.DTO.MainDTO;
import com.example.rest.DTO.MobileCallRecordsDTO;

@Repository
public interface MobileCallRecordsRepo extends JpaRepository<MobileCallRecords, Integer>{
	
	
	Set<MobileCallRecordsDTO> findRecords(PeopleMobile peoplemobile);
	MobileCallRecordsDTO mapMCRToDTO(MobileCallRecords mobilecallrecords);
	
	
	
	

}

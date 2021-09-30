package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.MobileCallRecords;

@Repository
public interface MobileCallRecordsRepo extends JpaRepository<MobileCallRecords, Integer> {

	List<MobileCallRecords> findByReceiverMSISDN(String receiverMSISDN);

}

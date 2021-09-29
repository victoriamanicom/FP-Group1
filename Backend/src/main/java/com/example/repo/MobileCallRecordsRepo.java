package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.MobileCallRecords;

@Repository
public interface MobileCallRecordsRepo extends JpaRepository<MobileCallRecords, Integer> {

}

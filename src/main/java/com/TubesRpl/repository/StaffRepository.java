package com.TubesRpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
    
}

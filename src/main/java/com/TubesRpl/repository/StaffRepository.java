package com.TubesRpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{

    List<Staff> findAllByHiddenFalse();

    Optional<Staff> findByHiddenFalseAndIdStaff(Integer idStaff);
    
}

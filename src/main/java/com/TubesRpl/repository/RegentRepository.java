package com.TubesRpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Regent;

@Repository
public interface RegentRepository extends JpaRepository <Regent, Integer>{
    
}

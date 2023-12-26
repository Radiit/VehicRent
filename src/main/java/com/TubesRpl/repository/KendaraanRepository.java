package com.TubesRpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;

@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, Integer> {
    
}

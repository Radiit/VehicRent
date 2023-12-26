package com.TubesRpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TubesRpl.vehicrent.backend.models.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}

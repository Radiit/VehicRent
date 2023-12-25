package com.TubesRpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>{
    
}

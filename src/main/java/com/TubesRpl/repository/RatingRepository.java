package com.TubesRpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>{
    
    List<Rating> findAllByHiddenFalse();

    Optional<Rating> findByHiddenFalseAndIdRating(Integer idRating);

}

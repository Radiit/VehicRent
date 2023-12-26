package com.TubesRpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Regent;

@Repository
public interface RegentRepository extends JpaRepository<Regent, Integer> {
    List<Regent> findAllByHiddenFalse();

    Optional<Regent> findByHiddenFalseAndIdRegent(Integer idRegent);

    @Query(value = "SELECT * FROM user WHERE role_user = \"Regent\" AND hidden = false AND nik = ?1", nativeQuery = true)
    Optional<Regent> findByHiddenFalseAndNikClient(Integer nikClient);
}

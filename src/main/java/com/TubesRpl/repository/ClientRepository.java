package com.TubesRpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

    List<Client> findAllByHiddenFalse();

    Optional<Client> findByHiddenFalseAndIdClient(Integer idClient);
}

package com.TubesRpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
 
}

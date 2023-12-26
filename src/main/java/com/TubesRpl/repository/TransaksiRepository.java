package com.TubesRpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Integer>{
    
    List<Transaksi> findAllByHiddenFalse();

    Optional<Transaksi> findByHiddenFalseAndIdTransaksi(Integer idTransaksi);

    List<Transaksi> findAllByHiddenFalseAndClient(Client client);

}

package com.TubesRpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;

@ComponentScan
@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, Integer> {
    @Query("SELECT k FROM Kendaraan k WHERE " +
           "LOWER(k.jenisKendaraan) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.merkKendaraan) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.model) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.nomorPlat) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.warna) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(CAST(k.tahun AS string)) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.nomorMesin) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.transmisi) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(CAST(k.hargaSewa AS string)) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.kondisiKendaraan) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.stnk) LIKE LOWER(concat('%', :keyword, '%')) OR " +
           "LOWER(k.valid) LIKE LOWER(concat('%', :keyword, '%'))")
    List<Kendaraan> searchByKeyword(@Param("keyword") String keyword);

    List<Kendaraan> findAllByHiddenFalse();
    
    Optional<Kendaraan> findByHiddenFalseAndIdKendaraan(Integer idKendaraan);
}

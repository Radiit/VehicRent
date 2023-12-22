package com.TubesRpl.repository;

import java.util.List;

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
            "k.jenis_Kendaraan LIKE %:keyword% OR " +
            "k.Nopol_Kendaraan LIKE %:keyword% OR " +
            "k.Merk_Kendaraan LIKE %:keyword% OR " +
            "k.Warna_Kendaraan LIKE %:keyword% OR " +
            "k.NoSTNK_Kendaraan LIKE %:keyword% OR " +
            "k.Kapasitas_Kendaraan LIKE %:keyword% OR " +
            "k.NoMesin_Kendaraan LIKE %:keyword%")
    List<Kendaraan> searchKendaraan(String keyword);

}

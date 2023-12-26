package com.TubesRpl.vehicrent.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class KendaraanServices implements BaseServices<Kendaraan>{
    
    @Autowired
    private KendaraanRepository kendaraanRepository;

    @Override
    public Response DisplayAllData() {

        List<Kendaraan> allKendaraan = new ArrayList();
        kendaraanRepository.findAll().forEach(allKendaraan::add);
        for (Kendaraan kendaraan : allKendaraan) {
            System.out.println("Kendaraan ID: " + kendaraan.getID_Kendaraan());
            System.out.println("Rental Agent: " + kendaraan.getRegent());
            System.out.println("Jenis Kendaraan: " + kendaraan.getJenis_Kendaraan());
            System.out.println("No Plat: " + kendaraan.getNopol_Kendaraan());
            System.out.println("Merk Kendaraan: " + kendaraan.getMerk_Kendaraan());
            System.out.println("Tahun Kendaraan: " + kendaraan.getTahun_Kendaraan());
            System.out.println("Warna Kendaraan: " + kendaraan.getWarna_Kendaraan());
            System.out.println("STNK Kendaraan: " + kendaraan.getNoSTNK_Kendaraan());
            System.out.println("Kapasitas Penumpang: " + kendaraan.getKapasitas_Kendaraan());
            System.out.println("No Mesin: " + kendaraan.getNoMesin_Kendaraan());
            System.out.println("Harga Sewa: " + kendaraan.getHargaSewa_Kendaraan());
            System.out.println("Maksimal Waktu Peminjaman: " + kendaraan.getMaksimalWaktu_Peminjaman());
            System.out.println("Status Kendaraan: " + kendaraan.getStatus_Kendaraan());;
            System.out.println("Status Validasi Kendaraan: " + kendaraan.getStatus_ValidasiKendaraan());   
        }
        return new Response(HttpStatus.OK.value(), "Success", allKendaraan);

    }

    @Override
    public Response DisplayByID(Integer id){
        try{
            Kendaraan kendaraan = kendaraanRepository.findById(id).orElse(null);
            if(kendaraan != null){
                System.out.println("Kendaraan ID: " + kendaraan.getID_Kendaraan());
                System.out.println("Rental Agent: " + kendaraan.getRegent());
                System.out.println("Jenis Kendaraan: " + kendaraan.getJenis_Kendaraan());
                System.out.println("No Plat: " + kendaraan.getNopol_Kendaraan());
                System.out.println("Merk Kendaraan: " + kendaraan.getMerk_Kendaraan());
                System.out.println("Tahun Kendaraan: " + kendaraan.getTahun_Kendaraan());
                System.out.println("Warna Kendaraan: " + kendaraan.getWarna_Kendaraan());
                System.out.println("STNK Kendaraan: " + kendaraan.getNoSTNK_Kendaraan());
                System.out.println("Kapasitas Penumpang: " + kendaraan.getKapasitas_Kendaraan());
                System.out.println("No Mesin: " + kendaraan.getNoMesin_Kendaraan());
                System.out.println("Harga Sewa: " + kendaraan.getHargaSewa_Kendaraan());
                System.out.println("Maksimal Waktu Peminjaman: " + kendaraan.getMaksimalWaktu_Peminjaman());
                System.out.println("Status Kendaraan: " + kendaraan.getStatus_Kendaraan());;
                System.out.println("Status Validasi Kendaraan: " + kendaraan.getStatus_ValidasiKendaraan());   
                return new Response(HttpStatus.OK.value(), "Success", kendaraan);
            }else{
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        }
        catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Create(Kendaraan model) {

        try{
            kendaraanRepository.save(model);
            return new Response(HttpStatus.OK.value(), "Success", model);
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", model);
        }
    }

    @Override
    public Response Update(Integer id, Kendaraan model){
        try{
            Kendaraan kendaraanTarget = kendaraanRepository.findById(id).orElse(null);
            if(kendaraanTarget != null){
                kendaraanTarget.setRegent(model.getRegent());
                kendaraanTarget.setJenis_Kendaraan(model.getJenis_Kendaraan());
                kendaraanTarget.setNopol_Kendaraan(model.getNopol_Kendaraan());
                kendaraanTarget.setMerk_Kendaraan(model.getMerk_Kendaraan());
                kendaraanTarget.setTahun_Kendaraan(model.getTahun_Kendaraan());
                kendaraanTarget.setWarna_Kendaraan(model.getWarna_Kendaraan());
                kendaraanTarget.setNoSTNK_Kendaraan(model.getNoSTNK_Kendaraan());
                kendaraanTarget.setKapasitas_Kendaraan(model.getKapasitas_Kendaraan());
                kendaraanTarget.setNoMesin_Kendaraan(model.getNoMesin_Kendaraan());
                kendaraanTarget.setHargaSewa_Kendaraan(model.getHargaSewa_Kendaraan());
                kendaraanTarget.setMaksimalWaktu_Peminjaman(model.getMaksimalWaktu_Peminjaman());
                kendaraanTarget.setStatus_Kendaraan(model.getStatus_Kendaraan());
                kendaraanTarget.setStatus_ValidasiKendaraan(model.getStatus_ValidasiKendaraan());

                kendaraanRepository.save(kendaraanTarget);
                return new Response(HttpStatus.OK.value(), "Success", kendaraanTarget);
            }else{
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id){
        try{
            Kendaraan kendaraan = kendaraanRepository.findById(id).orElse(null);
            if(kendaraan != null){
                kendaraanRepository.delete(kendaraan);
                return new Response(HttpStatus.OK.value(), "Success", null);
            }else{
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }
    

    
}

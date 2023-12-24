package com.TubesRpl.vehicrent.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.repository.RegentRepository;
import com.TubesRpl.vehicrent.backend.models.ImageKendaraan;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.payloads.requests.ImageKendaraanRequest;
import com.TubesRpl.vehicrent.backend.payloads.requests.KendaraanRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class KendaraanServices implements BaseServices<KendaraanRequest>{
    
    @Autowired
    private KendaraanRepository kendaraanRepository;

    @Autowired
    private RegentRepository regentrepository;

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
                List<ImageKendaraan> listImageKendaraan = kendaraan.getImageKendaraan();
                for (ImageKendaraan imageKendaraan : listImageKendaraan) {
                    System.out.println("Image Kendaraan: " + imageKendaraan.getImage());
                }
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
    public Response Create(KendaraanRequest request) {

        try{
            Kendaraan kendaraan = new Kendaraan();
            kendaraan.setRegent(regentrepository.findById(request.getID_Regent()).orElse(null));
            if (kendaraan.getRegent() == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Rental Agent not found", null);
            }
            kendaraan.setJenis_Kendaraan(request.getJenis_Kendaraan());
            kendaraan.setNopol_Kendaraan(request.getNopol_Kendaraan());
            kendaraan.setMerk_Kendaraan(request.getMerk_Kendaraan());
            kendaraan.setTahun_Kendaraan(request.getTahun_Kendaraan());
            kendaraan.setWarna_Kendaraan(request.getWarna_Kendaraan());
            kendaraan.setNoSTNK_Kendaraan(request.getNoSTNK_Kendaraan());
            kendaraan.setKapasitas_Kendaraan(request.getKapasitas_Kendaraan());
            kendaraan.setNoMesin_Kendaraan(request.getNoMesin_Kendaraan());
            kendaraan.setHargaSewa_Kendaraan(request.getHargaSewa_Kendaraan());
            kendaraan.setMaksimalWaktu_Peminjaman(request.getMaksimalWaktu_Peminjaman());
            kendaraan.setStatus_Kendaraan(request.getStatus_Kendaraan());
            kendaraan.setStatus_ValidasiKendaraan(request.getStatus_ValidasiKendaraan());
            List<ImageKendaraan> listImageKendaraan = new ArrayList<>();
            for (ImageKendaraanRequest imageKendaraanRequest : request.getImageKendaraan()) {
                ImageKendaraan imageKendaraan = new ImageKendaraan();
                imageKendaraan.setImage(imageKendaraanRequest.getImageKendaraan());
                imageKendaraan.setKendaraan(kendaraan);
                listImageKendaraan.add(imageKendaraan);
            }
            kendaraan.setImageKendaraan(listImageKendaraan);
            kendaraanRepository.save(kendaraan);

            return new Response(HttpStatus.OK.value(), "Success", kendaraan);
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Update(Integer id, KendaraanRequest request){
        try{
            Kendaraan kendaraanTarget = kendaraanRepository.findById(id).orElse(null);
            if(kendaraanTarget != null){
                kendaraanTarget.setRegent(regentrepository.findById(id).orElse(null));
                kendaraanTarget.setJenis_Kendaraan(request.getJenis_Kendaraan());
                kendaraanTarget.setNopol_Kendaraan(request.getNopol_Kendaraan());
                kendaraanTarget.setMerk_Kendaraan(request.getMerk_Kendaraan());
                kendaraanTarget.setTahun_Kendaraan(request.getTahun_Kendaraan());
                kendaraanTarget.setWarna_Kendaraan(request.getWarna_Kendaraan());
                kendaraanTarget.setNoSTNK_Kendaraan(request.getNoSTNK_Kendaraan());
                kendaraanTarget.setKapasitas_Kendaraan(request.getKapasitas_Kendaraan());
                kendaraanTarget.setNoMesin_Kendaraan(request.getNoMesin_Kendaraan());
                kendaraanTarget.setHargaSewa_Kendaraan(request.getHargaSewa_Kendaraan());
                kendaraanTarget.setMaksimalWaktu_Peminjaman(request.getMaksimalWaktu_Peminjaman());
                kendaraanTarget.setStatus_Kendaraan(request.getStatus_Kendaraan());
                kendaraanTarget.setStatus_ValidasiKendaraan(request.getStatus_ValidasiKendaraan());

                List<ImageKendaraan> listImageKendaraan = new ArrayList<>();
                for (ImageKendaraanRequest imageKendaraanRequest : request.getImageKendaraan()) {
                    ImageKendaraan imageKendaraan = new ImageKendaraan();
                    imageKendaraan.setImage(imageKendaraanRequest.getImageKendaraan());
                    imageKendaraan.setKendaraan(kendaraanTarget);
                    listImageKendaraan.add(imageKendaraan);
                }

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
    
    public Response search(String keyword){
        try{
            List<Kendaraan> kendaraan = kendaraanRepository.searchKendaraan(keyword);
            if(kendaraan != null){
                return new Response(HttpStatus.OK.value(), "Success", kendaraan);
            }else{
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }
    
}

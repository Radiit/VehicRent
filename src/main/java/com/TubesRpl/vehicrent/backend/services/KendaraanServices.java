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
import com.TubesRpl.vehicrent.backend.models.Rating;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.payloads.requests.ImageKendaraanRequest;
import com.TubesRpl.vehicrent.backend.payloads.requests.KendaraanRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class KendaraanServices implements BaseServices<KendaraanRequest> {

    @Autowired
    private KendaraanRepository kendaraanRepository;

    @Autowired
    private RegentRepository regentrepository;

    @Override
    public Response DisplayAllData() {
        List<Kendaraan> allKendaraan = kendaraanRepository.findAllByHiddenFalse();
        if (allKendaraan.isEmpty()) {
            return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
        }
        System.out.println("Display All Kendaraan Data");
        return new Response(HttpStatus.OK.value(), "Success", allKendaraan);

    }

    @Override
    public Response DisplayByID(Integer id) {
        try {
            Kendaraan kendaraan = kendaraanRepository.findByHiddenFalseAndIdKendaraan(id).orElse(null);
            if (kendaraan != null) {
                System.out.println("Display Kendaraan Data By ID" + id);
                return new Response(HttpStatus.OK.value(), "Success", kendaraan);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Create(KendaraanRequest request) {

        try {
            Regent regent = regentrepository.findById(request.getIdRegent()).orElse(null);
            if (regent == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Rental Agent not found", null);
            }
            Kendaraan kendaraan = new Kendaraan();
            kendaraan.setRegent(regent);
            kendaraan.setJenisKendaraan(request.getJenisKendaraan());
            kendaraan.setMerkKendaraan(request.getMerkKendaraan());
            kendaraan.setModel(request.getModel());
            kendaraan.setNomorPlat(request.getNomorPlat());
            kendaraan.setWarna(request.getWarna());
            kendaraan.setTahun(request.getTahun());
            kendaraan.setNomorMesin(request.getNomorMesin());
            kendaraan.setTransmisi(request.getTransmisi());
            kendaraan.setHargaSewa(request.getHargaSewa());
            kendaraan.setKondisiKendaraan(request.getKondisiKendaraan());
            kendaraan.setStnk(request.getStnk());
            kendaraan.setTotalOrdered(0);
            kendaraan.setTotalRating(0);

            List<ImageKendaraan> listImageKendaraan = new ArrayList<>();
            for (ImageKendaraanRequest imageKendaraanRequest : request.getImageKendaraan()) {
                ImageKendaraan imageKendaraan = new ImageKendaraan();
                imageKendaraan.setImage(imageKendaraanRequest.getImage());
                imageKendaraan.setKendaraan(kendaraan);
                listImageKendaraan.add(imageKendaraan);
            }
            kendaraan.setImageKendaraan(listImageKendaraan);

            List<Rating> listRating = new ArrayList<>();
            kendaraan.setRating(listRating);
            kendaraan.setValid("Pending");
            kendaraan.setHidden(false);
            kendaraanRepository.save(kendaraan);

            return new Response(HttpStatus.OK.value(), "Success", kendaraan);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Update(Integer id, KendaraanRequest request) {
        try {
            Kendaraan kendaraanTarget = kendaraanRepository.findById(id).orElse(null);
            if (kendaraanTarget != null) {

                kendaraanTarget.setJenisKendaraan(request.getJenisKendaraan());
                kendaraanTarget.setMerkKendaraan(request.getMerkKendaraan());
                kendaraanTarget.setModel(request.getModel());
                kendaraanTarget.setNomorPlat(request.getNomorPlat());
                kendaraanTarget.setWarna(request.getWarna());
                kendaraanTarget.setTahun(request.getTahun());
                kendaraanTarget.setNomorMesin(request.getNomorMesin());
                kendaraanTarget.setTransmisi(request.getTransmisi());
                kendaraanTarget.setHargaSewa(request.getHargaSewa());
                kendaraanTarget.setKondisiKendaraan(request.getKondisiKendaraan());
                kendaraanTarget.setStnk(request.getStnk());

                List<ImageKendaraan> listImageKendaraan = new ArrayList<>();
                for (ImageKendaraanRequest imageKendaraanRequest : request.getImageKendaraan()) {
                    ImageKendaraan imageKendaraan = new ImageKendaraan();
                    imageKendaraan.setImage(imageKendaraanRequest.getImage());
                    imageKendaraan.setKendaraan(kendaraanTarget);
                    listImageKendaraan.add(imageKendaraan);
                }

                kendaraanTarget.setImageKendaraan(listImageKendaraan);
                kendaraanTarget.setValid("Pending");
                kendaraanTarget.setHidden(false);
                kendaraanRepository.save(kendaraanTarget);
                System.out.println("Update Kendaraan Data By ID" + id);
                return new Response(HttpStatus.OK.value(), "Success", kendaraanTarget);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id) {
        try {
            Kendaraan kendaraan = kendaraanRepository.findByHiddenFalseAndIdKendaraan(id).orElse(null);
            if (kendaraan != null) {
                kendaraan.setHidden(true);
                kendaraanRepository.save(kendaraan);
                System.out.println("Delete Kendaraan Data By ID" + id);
                return new Response(HttpStatus.OK.value(), "Success", null);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response search(String keyword) {
        try {
            List<Kendaraan> kendaraan = kendaraanRepository.searchByKeyword(keyword);
            if (kendaraan != null) {
                return new Response(HttpStatus.OK.value(), "Success", kendaraan);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

}

package com.TubesRpl.vehicrent.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.RekomendasiRepository;
import com.TubesRpl.vehicrent.backend.models.Rekomendasi;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class RekomendasiServices implements BaseServices<Rekomendasi>{
    @Autowired
    private RekomendasiRepository rekomendasirepository;

    @Override
    public Response DisplayAllData() {
        List<Rekomendasi> allRekomendasi = new ArrayList<>();
        rekomendasirepository.findAll().forEach(allRekomendasi::add);
        for (Rekomendasi rekomendasi : allRekomendasi) {
            System.out.println("ID Rekomendasi: " + rekomendasi.getID_Rekomendasi());
        }
        return new Response(HttpStatus.OK.value(), "Success", allRekomendasi);
    }

    @Override
    public Response DisplayByID(Integer id) {
        try {
            Rekomendasi rekomendasi = rekomendasirepository.findById(id).orElse(null);
            if (rekomendasi != null) {
                System.out.println("ID Rekomendasi: " + rekomendasi.getID_Rekomendasi());
                return new Response(HttpStatus.OK.value(), "Success", rekomendasi);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Rekomendasi not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Create(Rekomendasi model) {
        try {
            rekomendasirepository.save(model);
            return new Response(HttpStatus.OK.value(), "Success", model);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", model);
        }
    }

    @Override
    public Response Update(Integer id, Rekomendasi model) {
        try {
            Rekomendasi rekomendasi = rekomendasirepository.findById(id).orElse(null);
            if (rekomendasi != null) {
                rekomendasi.setID_Rekomendasi(model.getID_Rekomendasi());
                rekomendasirepository.save(rekomendasi);
                return new Response(HttpStatus.OK.value(), "Success", rekomendasi);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Rekomendasi not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id) {
        try {
            Rekomendasi rekomendasi = rekomendasirepository.findById(id).orElse(null);
            if (rekomendasi != null) {
                rekomendasirepository.deleteById(id);
                return new Response(HttpStatus.OK.value(), "Success", rekomendasi);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Rekomendasi not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

}
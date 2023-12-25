package com.TubesRpl.vehicrent.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.RegentRepository;
import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.RegentRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class RegentServices implements BaseServices<RegentRequest> {
    @Autowired
    private RegentRepository regentRepository;

    @Autowired
    private UserRepository userrepository;

    @Override
    public Response DisplayAllData() {
        List<Regent> allRegent = regentRepository.findAllByHiddenFalse();
        if (allRegent.isEmpty()) {
            return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", null);
        }
        System.out.println("Display all regent data");
        return new Response(HttpStatus.OK.value(), "Success", allRegent);
    }

    @Override
    public Response Create(RegentRequest request) {
        try {
            User user = userrepository.findByHiddenFalseAndNik(request.getNik()).orElse(null);
            if (user == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "User not found", request);
            }
            Regent regent = new Regent();
            regent.setUser(user);
            regent.setListKendaraan(null);
            regent.setHidden(false);
            regent.setValid("Pending");
            regentRepository.save(regent);
            System.out.println("Create new regent with id: " + regent.getIdRegent() + " and NIK: " + regent.getUser().getNIK_User());
            return new Response(HttpStatus.OK.value(), "Success", regent);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", request);
        }
    }

    @Override
    public Response Update(Integer id, RegentRequest request) {
        try {
            Regent regent = regentRepository.findByHiddenFalseAndIdRegent(id).orElse(null);
            if (regent != null) {
                User user = userrepository.findByHiddenFalseAndNik(request.getNik()).orElse(null);
                if (user == null) {
                    return new Response(HttpStatus.NOT_FOUND.value(), "User not found", request);
                }
                regent.setUser(user);
                regent.setListKendaraan(null);
                regent.setHidden(false);
                regent.setValid("Pending");
                regentRepository.save(regent);
                System.out.println("Update regent with id: " + regent.getIdRegent() + " and NIK: " + regent.getUser().getNIK_User());
                return new Response(HttpStatus.OK.value(), "Success", regent);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", request);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id) {
        try {
            Regent regent = regentRepository.findById(id).orElse(null);
            if (regent != null) {
                regent.setHidden(true);
                regentRepository.save(regent);
                System.out.println("Delete regent with id: " + regent.getIdRegent());
                return new Response(HttpStatus.OK.value(), "Success", regent);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response DisplayByID(Integer id) {
        try {
            Regent regent = regentRepository.findByHiddenFalseAndIdRegent(id).orElse(null);
            if (regent != null) {
                System.out.println("Display regent with id: " + regent.getIdRegent());
                return new Response(HttpStatus.OK.value(), "Success", regent);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }
}

package com.TubesRpl.vehicrent.backend.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.repository.RegentRepository;
import com.TubesRpl.repository.TransaksiRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.Transaksi;
import com.TubesRpl.vehicrent.backend.payloads.requests.TransaksiRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class TransaksiServices implements BaseServices<TransaksiRequest> {
    @Autowired
    TransaksiRepository transaksiRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    RegentRepository regentRepository;
    @Autowired
    KendaraanRepository kendaraanRepository;

    @Override
    public Response DisplayAllData() {
        List<Transaksi> allTransaksi = new ArrayList<>();
        transaksiRepository.findAll().forEach(allTransaksi::add);
        return new Response(HttpStatus.OK.value(), "Success", allTransaksi);
    }

    @Override
    // override method display by id
    public Response DisplayByID(Integer id) {
        Transaksi transaksi = transaksiRepository.findById(id).orElse(null);
        if (transaksi != null) {
            return new Response(HttpStatus.OK.value(), "Success", transaksi);
        } else {
            return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
        }
    }

    @Override
    public Response Create(TransaksiRequest request) {
        try {
            Transaksi transaksi = new Transaksi();
            Client client = clientRepository.findById(request.getID_Client()).orElse(null);
            if (client == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", request);
            }
            Regent regent = regentRepository.findById(request.getID_Regent()).orElse(null);
            if (regent == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", request);
            }
            Kendaraan kendaraan = kendaraanRepository.findById(request.getID_Kendaraan()).orElse(null);
            if (kendaraan == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", request);
            }
            transaksi.setClient(client);
            transaksi.setRegent(regent);
            transaksi.setKendaraan(kendaraan);
            transaksi.setOrderName(request.getOrderName());
            transaksi.setPhoneNumber(request.getPhoneNumber());
            transaksi.setPickUpAddress(request.getPickUpAddress());
            transaksi.setDropOffAddress(request.getDropOffAddress());
            transaksi.setDestination(request.getDestination());
            transaksi.setRentDateStart(request.getRentDateStart());
            transaksi.setRentDateEnd(request.getRentDateEnd());
            transaksi.setDateTransaksi(LocalDateTime.now());
            transaksi.setStatus(request.getStatus());

            // hitung total hari kendaraan disewa
            LocalDate startLocalDate = request.getRentDateStart().toLocalDate();
            LocalDate endLocalDate = request.getRentDateEnd().toLocalDate();
            long lamaSewa = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
            transaksi.setLamaSewa(lamaSewa);

            // hitung harga total dengan pajak
            double pajak = 0.1;
            long hargaTemp = kendaraan.getHargaSewa_Kendaraan() * lamaSewa;
            int totalPajak = (int) (hargaTemp * pajak);
            transaksi.setHargaTotal((int) (hargaTemp + totalPajak));

            transaksiRepository.save(transaksi);
            return new Response(HttpStatus.OK.value(), "Success", transaksi);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", request);
        }
    }

    @Override
    public Response Update(Integer id, TransaksiRequest request) {
        try {
            Transaksi transaksi = transaksiRepository.findById(id).orElse(null);
            if (transaksi != null) {
                Client client = clientRepository.findById(request.getID_Client()).orElse(null);
                if (client == null) {
                    return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", request);
                }
                Regent regent = regentRepository.findById(request.getID_Regent()).orElse(null);
                if (regent == null) {
                    return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", request);
                }
                Kendaraan kendaraan = kendaraanRepository.findById(request.getID_Kendaraan()).orElse(null);
                if (kendaraan == null) {
                    return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", request);
                }
                transaksi.setClient(client);
                transaksi.setRegent(regent);
                transaksi.setKendaraan(kendaraan);
                transaksi.setOrderName(request.getOrderName());
                transaksi.setPhoneNumber(request.getPhoneNumber());
                transaksi.setPickUpAddress(request.getPickUpAddress());
                transaksi.setDropOffAddress(request.getDropOffAddress());
                transaksi.setDestination(request.getDestination());
                transaksi.setRentDateStart(request.getRentDateStart());
                transaksi.setRentDateEnd(request.getRentDateEnd());
                transaksi.setDateTransaksi(LocalDateTime.now());
                transaksi.setStatus(request.getStatus());

                // hitung total hari kendaraan disewa
                LocalDate startLocalDate = request.getRentDateStart().toLocalDate();
                LocalDate endLocalDate = request.getRentDateEnd().toLocalDate();
                long lamaSewa = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
                transaksi.setLamaSewa(lamaSewa);

                // hitung harga total dengan pajak
                double pajak = 0.1;
                long hargaTemp = kendaraan.getHargaSewa_Kendaraan() * lamaSewa;
                int totalPajak = (int) (hargaTemp * pajak);
                transaksi.setHargaTotal((int) (hargaTemp + totalPajak));

                transaksiRepository.save(transaksi);
                return new Response(HttpStatus.OK.value(), "Success", transaksi);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id) {
        try {
            Transaksi transaksi = transaksiRepository.findById(id).orElse(null);
            if (transaksi != null) {
                transaksiRepository.delete(transaksi);
                return new Response(HttpStatus.OK.value(), "Success", transaksi);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

}

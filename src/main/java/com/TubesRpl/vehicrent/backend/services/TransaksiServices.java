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
import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.Transaksi;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.TransaksiRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class TransaksiServices implements BaseServices<TransaksiRequest> {
    @Autowired
    TransaksiRepository transaksiRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegentRepository regentRepository;
    @Autowired
    KendaraanRepository kendaraanRepository;

    @Override
    public Response DisplayAllData() {
        List<Transaksi> allTransaksi = transaksiRepository.findAllByHiddenFalse();
        if (allTransaksi.isEmpty()) {
            return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
        }
        System.out.println("Display all transaksi data");
        return new Response(HttpStatus.OK.value(), "Success", allTransaksi);
    }

    @Override
    // override method display by id
    public Response DisplayByID(Integer id) {
        Transaksi transaksi = transaksiRepository.findByHiddenFalseAndIdTransaksi(id).orElse(null);
        if (transaksi != null) {
            System.out.println("Display transaksi data by id " + id);
            return new Response(HttpStatus.OK.value(), "Success", transaksi);
        } else {
            return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
        }
    }

    @Override
    public Response Create(TransaksiRequest request) {
        Transaksi transaksi = new Transaksi();

        try {
            Client client = clientRepository.findByHiddenFalseAndIdClient(request.getID_Client()).orElse(null);
            // User client = userRepository.findById(request.getID_Client()).orElse(null);

            if (client == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", request);
            }

            Regent regent = regentRepository.findByHiddenFalseAndIdRegent(request.getID_Regent()).orElse(null);
            // User regent = userRepository.findById(request.getID_Regent()).orElse(null);

            if (regent == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", request);
            }
            Kendaraan kendaraan = kendaraanRepository.findByHiddenFalseAndIdKendaraan(request.getID_Kendaraan())
                    .orElse(null);
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
            transaksi.setStatus("WaitingPayment");

            // hitung total hari kendaraan disewa
            LocalDate startLocalDate = request.getRentDateStart().toLocalDate();
            LocalDate endLocalDate = request.getRentDateEnd().toLocalDate();
            long lamaSewa = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
            transaksi.setLamaSewa(lamaSewa);

            // hitung harga total dengan pajak
            double pajak = 0.1;
            long hargaTemp = kendaraan.getHargaSewa() * lamaSewa;
            int totalPajak = (int) (hargaTemp * pajak);
            transaksi.setHargaTotal((int) (hargaTemp + totalPajak));

            transaksi.setHidden(false);
            transaksiRepository.save(transaksi);
            return new Response(HttpStatus.OK.value(), "Success", transaksi);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", transaksi);
        }
    }

    @Override
    public Response Update(Integer id, TransaksiRequest request) {
        try {
            Transaksi transaksi = transaksiRepository.findById(id).orElse(null);
            if (transaksi != null) {
                User client = userRepository.findByHiddenFalseAndNik(request.getID_Client()).orElse(null);
                if (client == null) {
                    return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", request);
                }
                User regent = userRepository.findByHiddenFalseAndNik(request.getID_Regent()).orElse(null);
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

                // hitung total hari kendaraan disewa
                LocalDate startLocalDate = request.getRentDateStart().toLocalDate();
                LocalDate endLocalDate = request.getRentDateEnd().toLocalDate();
                long lamaSewa = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
                transaksi.setLamaSewa(lamaSewa);

                // hitung harga total dengan pajak
                double pajak = 0.1;
                long hargaTemp = kendaraan.getHargaSewa() * lamaSewa;
                int totalPajak = (int) (hargaTemp * pajak);
                transaksi.setHargaTotal((int) (hargaTemp + totalPajak));

                transaksi.setHidden(false);
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
            Transaksi transaksi = transaksiRepository.findByHiddenFalseAndIdTransaksi(id).orElse(null);
            if (transaksi != null) {
                transaksi.setHidden(true);
                transaksiRepository.save(transaksi);
                System.out.println("Delete transaksi data by id " + id);
                return new Response(HttpStatus.OK.value(), "Success", transaksi);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response UpdateStatus(Integer id, String status) {
        try {
            Transaksi transaksi = transaksiRepository.findByHiddenFalseAndIdTransaksi(id).orElse(null);
            if (transaksi != null) {
                transaksi.setStatus(status);
                if (status.equals("Done")) {
                    Kendaraan kendaraan = transaksi.getKendaraan();
                    kendaraan.setTotalOrdered(kendaraan.getTotalOrdered() + 1);
                    kendaraanRepository.save(kendaraan);
                }
                transaksiRepository.save(transaksi);
                System.out.println("Update transaksi status by id " + id + " to " + status);
                return new Response(HttpStatus.OK.value(), "Success", transaksi);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

}

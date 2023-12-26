package com.TubesRpl.vehicrent.backend.services;

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
public class TransaksiServices implements BaseServices<TransaksiRequest>{
    @Autowired
    TransaksiRepository transaksiRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    RegentRepository regentRepository;
    @Autowired
    KendaraanRepository kendaraanRepository;

    @Override
    public Response DisplayAllData(){
        List<Transaksi> allTransaksi = new ArrayList<>();
        transaksiRepository.findAll().forEach(allTransaksi::add);
        for (Transaksi transaksi : allTransaksi){
            System.out.println("ID Transaksi: " + transaksi.getID_Transaksi());
            System.out.println("Regent: " + transaksi.getRegent());
            System.out.println("Client: " + transaksi.getClient());
            System.out.println("ID Kendaraan: " + transaksi.getKendaraan());
            System.out.println("Waktu Pemesanan: " + transaksi.getWaktu_Pemesanan());
            System.out.println("Harga Total Pemesanan: " + transaksi.getHargatotal_Pemesanan());
            System.out.println("Status Pemesanan: " + transaksi.getStatus_Pemesanan());
            System.out.println("Virtual Account Number: " + transaksi.getVirtualAccountNumber());
        }
        return new Response(HttpStatus.OK.value(), "Success", allTransaksi);
    }

    @Override
    //override method display by id
    public Response DisplayByID(Integer id){
        Transaksi transaksi = transaksiRepository.findById(id).orElse(null);
        if (transaksi != null){
            System.out.println("ID Transaksi: " + transaksi.getID_Transaksi());
            System.out.println("Regent: " + transaksi.getRegent());
            System.out.println("Client: " + transaksi.getClient());
            System.out.println("ID Kendaraan: " + transaksi.getKendaraan());
            System.out.println("Waktu Pemesanan: " + transaksi.getWaktu_Pemesanan());
            System.out.println("Harga Total Pemesanan: " + transaksi.getHargatotal_Pemesanan());
            System.out.println("Status Pemesanan: " + transaksi.getStatus_Pemesanan());
            System.out.println("Virtual Account Number: " + transaksi.getVirtualAccountNumber());
            return new Response(HttpStatus.OK.value(), "Success", transaksi);
        } else {
            return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
        }
    }

    @Override
    public Response Create(TransaksiRequest request){
        try{
            Transaksi transaksi = new Transaksi();
            System.out.println(request.getID_Client());
            System.out.println(request.getID_Regent());
            System.out.println(request.getID_Kendaraan());
            Client client = clientRepository.findById(request.getID_Client()).orElse(null);
            if (client == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", request);
            }
            System.out.println("2");
            Regent regent = regentRepository.findById(request.getID_Regent()).orElse(null);
            if (regent == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", request);
            }
            System.out.println("3");
            Kendaraan kendaraan = kendaraanRepository.findById(request.getID_Kendaraan()).orElse(null);
            if (kendaraan == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", request);
            }
            transaksi.setWaktu_Pemesanan(request.getWaktu_Pemesanan());
            transaksi.setHargatotal_Pemesanan(request.getHargatotal_Pemesanan());
            transaksi.setStatus_Pemesanan(request.getStatus_Pemesanan());
            transaksi.setVirtualAccountNumber(request.getVirtualAccountNumber());
            System.out.println("4");
            transaksi.setClient(client);
            transaksi.setRegent(regent);
            transaksi.setKendaraan(kendaraan);
            System.out.println("5");
            transaksiRepository.save(transaksi);
            System.out.println("6");
            return new Response(HttpStatus.OK.value(), "Success", transaksi);
        }catch (Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", request);
        }
    }
    
    @Override
    public Response Update(Integer id, TransaksiRequest request){
        try{
            Transaksi transaksi = transaksiRepository.findById(id).orElse(null);
            if (transaksi != null){
                transaksi.setClient(transaksi.getClient());
                transaksi.setRegent(transaksi.getRegent());
                transaksi.setKendaraan(transaksi.getKendaraan());
                transaksi.setWaktu_Pemesanan(request.getWaktu_Pemesanan());
                transaksi.setHargatotal_Pemesanan(request.getHargatotal_Pemesanan());
                transaksi.setStatus_Pemesanan(request.getStatus_Pemesanan());
                transaksi.setVirtualAccountNumber(request.getVirtualAccountNumber());
                transaksiRepository.save(transaksi);
                return new Response(HttpStatus.OK.value(), "Success", transaksi);
            }else{
                return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
            }
        }catch (Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id){
        try{
            Transaksi transaksi = transaksiRepository.findById(id).orElse(null);
            if (transaksi != null){
                transaksiRepository.delete(transaksi);
                return new Response(HttpStatus.OK.value(), "Success", transaksi);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Transaksi not found", null);
            }
        }catch (Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

}

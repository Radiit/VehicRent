package com.TubesRpl.vehicrent.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TubesRpl.vehicrent.backend.payloads.requests.TransaksiRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;

@Controller
@RequestMapping("/transaksi")
public class TransaksiController {
    @Autowired
    private BaseServices<TransaksiRequest> transaksiServices;
    
    @RequestMapping("/display")
    public ResponseEntity<?> index(){
        Response allTransaksi = transaksiServices.DisplayAllData();
        return ResponseEntity.status(200).body(allTransaksi);
    }

    @RequestMapping("/display/{id}")
    public ResponseEntity<?> displayById(@PathVariable Integer id){
        Response transaksiByID = transaksiServices.DisplayByID(id);
        return ResponseEntity.status(200).body(transaksiByID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateAccount(@RequestBody TransaksiRequest transaksibaru){
        Response response = transaksiServices.Create(transaksibaru);
        if (response.getStatus() == HttpStatus.OK.value()){
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateAccount(@RequestBody TransaksiRequest transaksibaru, @PathVariable Integer id){
        Response allTransaksi = transaksiServices.Update(id, transaksibaru);
        return ResponseEntity.status(200).body(allTransaksi);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id){
        Response response = transaksiServices.Delete(id);
        if (response.getStatus() == HttpStatus.OK.value()){
            return ResponseEntity.ok(response);
        }else if (response.getStatus() == HttpStatus.NOT_FOUND.value()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

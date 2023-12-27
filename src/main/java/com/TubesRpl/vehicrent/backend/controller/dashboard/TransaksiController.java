package com.TubesRpl.vehicrent.backend.controller.dashboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.TubesRpl.repository.TransaksiRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Transaksi;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.TransaksiRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;
// import com.TubesRpl.vehicrent.backend.services.PdfGenerateServices;
import com.TubesRpl.vehicrent.backend.services.TransaksiServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("dashboard/transaksi")
public class TransaksiController {
    @Autowired
    private TransaksiServices transaksiServices;

    @Autowired
    private TransaksiRepository transaksiRepository;

    // @Autowired
    // private PdfGenerateServices pdfGenerateServices;

    @RequestMapping("/display")
    public ResponseEntity<?> index() {
        Response allTransaksi = transaksiServices.DisplayAllData();
        return ResponseEntity.status(200).body(allTransaksi);
    }

    @RequestMapping("/display/{id}")
    public ResponseEntity<?> displayById(@PathVariable Integer id) {
        Response transaksiByID = transaksiServices.DisplayByID(id);
        return ResponseEntity.status(200).body(transaksiByID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateAccount(
            @RequestBody TransaksiRequest transaksibaru,
            HttpSession session) {

        Client userSession = (Client) session.getAttribute("client");

        if (userSession == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not logged in!");
        }

        transaksibaru.setID_Client(userSession.getIdClient());

        Response response = transaksiServices.Create(transaksibaru);

        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateAccount(@RequestBody TransaksiRequest transaksibaru, @PathVariable Integer id) {
        Response allTransaksi = transaksiServices.Update(id, transaksibaru);
        return ResponseEntity.status(200).body(allTransaksi);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id) {
        Response response = transaksiServices.Delete(id);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/status/{id}")
    public ResponseEntity<?> UpdateStatus(@PathVariable Integer id, @RequestPart("status") String status) {
        Response response = transaksiServices.UpdateStatus(id, status);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/generate/{id}")
    public ResponseEntity<?> GeneratePdf(@PathVariable Integer id) {
        Transaksi transaksi = transaksiRepository.findById(id).orElse(null);

        if (transaksi == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transaksi not found!");
        }

        Map<String, Object> data = new HashMap<>();

        data.put("transaksi", (Transaksi) transaksi);

        String fileName = "receipt-" + UUID.randomUUID().toString() + ".pdf";
        // pdfGenerateServices.generatePdfFile("receipt", data, fileName);

        Response response = new Response(HttpStatus.OK.value(), "Success generate pdf!", fileName);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

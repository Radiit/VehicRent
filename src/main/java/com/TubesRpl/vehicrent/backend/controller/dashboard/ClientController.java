package com.TubesRpl.vehicrent.backend.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TubesRpl.vehicrent.backend.payloads.requests.ClientRequest;
import com.TubesRpl.vehicrent.backend.payloads.requests.RatingRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;
import com.TubesRpl.vehicrent.backend.services.ClientServices;
import com.TubesRpl.vehicrent.backend.services.RatingServices;

@Controller
@RequestMapping("dashboard/client")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @Autowired
    private RatingServices ratingServices;

    @RequestMapping("/display")
    public ResponseEntity<?> index() {
        Response allClient = clientServices.DisplayAllData();
        return ResponseEntity.status(200).body(allClient);
    }

    @RequestMapping("/display/{id}")
    public ResponseEntity<?> displayById(@PathVariable Integer id) {
        Response clientByID = clientServices.DisplayByID(id);
        return ResponseEntity.status(200).body(clientByID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateAccount(@RequestBody ClientRequest clientbaru) {
        Response response = clientServices.Create(clientbaru);
        if (response.getStatus() == 200) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateAccount(@RequestBody ClientRequest clientbaru, @PathVariable Integer id) {
        Response allClient = clientServices.Update(id, clientbaru);
        return ResponseEntity.status(200).body(allClient);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id) {
        Response response = clientServices.Delete(id);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    //ini contoh pemakaian rating, silahkan disesuakan lagi dengan kebutuhan
    @PostMapping("/rate")
    public ResponseEntity<Response> giveRating(@RequestBody RatingRequest ratingRequest) {
        Response response = ratingServices.giveRating(ratingRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/rate/edit/{id}")
    public ResponseEntity<Response> updateRating(@PathVariable Integer id, @RequestBody RatingRequest ratingRequest) {
        Response response = ratingServices.updateRating(id, ratingRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping("/rate/{id}")
    public ResponseEntity<?> displayRating(@PathVariable Integer id) {
        Response response = ratingServices.displayRatingById(id);
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/rate/delete/{id}")
    public ResponseEntity<?> deleteRating(@PathVariable Integer id) {
        Response response = ratingServices.deleteRating(id);
        return ResponseEntity.status(200).body(response);
    }
}

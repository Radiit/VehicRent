package com.TubesRpl.vehicrent.backend.controller.dashboard;

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
import com.TubesRpl.vehicrent.backend.payloads.requests.RegentRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.RoleServices;


@Controller
@RequestMapping("dashboard/regent")
public class RegentController {
    @Autowired
    private RoleServices<RegentRequest> regentServices;

    @RequestMapping("/display")
    public ResponseEntity<?> index() {
        Response allregent = regentServices.DisplayAllData();
        return ResponseEntity.status(200).body(allregent);
    }

    @RequestMapping("/display/{id}")
    public ResponseEntity<?> displayById(@PathVariable Integer id) {
        Response regentByID = regentServices.DisplayByID(id);
        return ResponseEntity.status(200).body(regentByID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateAccount(@RequestBody RegentRequest regentbaru) {
        Response response = regentServices.Create(regentbaru);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateAccount(@RequestBody RegentRequest regentbaru, @PathVariable Integer id) {
        Response allregent = regentServices.Update(id, regentbaru);
        return ResponseEntity.status(200).body(allregent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id) {
        Response response = regentServices.Delete(id);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
}

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

import com.TubesRpl.vehicrent.backend.payloads.requests.StaffRequest;
import com.TubesRpl.vehicrent.backend.payloads.requests.UserRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;
import com.TubesRpl.vehicrent.backend.services.StaffServices;

@Controller
@RequestMapping("dashboard/staff")
public class StaffController {
    
    @Autowired
    private BaseServices<StaffRequest> staffServices;

    @RequestMapping("/display")
    public ResponseEntity<?> index(){
        Response allStaff = staffServices.DisplayAllData();
        return ResponseEntity.status(200).body(allStaff);
    }

    @RequestMapping("/display/{id}")
    public ResponseEntity<?> displayById(@PathVariable Integer id){
        Response staffByID = staffServices.DisplayByID(id);
        return ResponseEntity.status(200).body(staffByID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateAccount(@RequestBody StaffRequest staffbaru){
        Response response = staffServices.Create(staffbaru);
        if (response.getStatus() == HttpStatus.OK.value()){
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateAccount(@RequestBody StaffRequest staffbaru, @PathVariable Integer id){
        Response allStaff = staffServices.Update(id, staffbaru);
        return ResponseEntity.status(200).body(allStaff);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id){
        Response response = staffServices.Delete(id);
        if (response.getStatus() == HttpStatus.OK.value()){
            return ResponseEntity.ok(response);
        }else if (response.getStatus() == HttpStatus.NOT_FOUND.value()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}

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

import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.UserRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("dashboard/user")
public class UserController {
    @Autowired
    private BaseServices<UserRequest> display;

    @RequestMapping("/display")
    public ResponseEntity<?> index() {
        Response alluser = display.DisplayAllData();
        return ResponseEntity.status(200).body(alluser);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<?> indexByID(@PathVariable Integer id) {
        Response userByID = display.DisplayByID(id);;
        return ResponseEntity.status(userByID.getStatus()).body(userByID);
}
    
    @PostMapping("/create")
    public ResponseEntity<?> CreateAccount(@RequestBody UserRequest Userbaru, Model model) {
        Response response = display.Create(Userbaru);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateUser(@RequestBody UserRequest Userbaru, @PathVariable Integer id) {
        Response response = display.Update(id, Userbaru);
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id) {
        Response response = display.Delete(id);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}

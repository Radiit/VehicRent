
package com.TubesRpl.vehicrent.backend.controller.dashboard;

import com.TubesRpl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.UserRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;

import ch.qos.logback.core.model.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("dashboard/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BaseServices<UserRequest> display;

    @RequestMapping("/display")
    public ResponseEntity<?> index() {
        Response alluser = display.DisplayAllData();
        return ResponseEntity.status(200).body(alluser);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<?> indexByID(@PathVariable Integer id) {
        Response userByID = display.DisplayByID(id);
        ;
        return ResponseEntity.status(userByID.getStatus()).body(userByID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateAccount(
            @RequestPart("nik") String nik,
            @RequestPart("role_user") String role_user,
            @RequestPart("nama_depan") String nama_depan,
            @RequestPart("nama_belakang") String nama_belakang,
            @RequestPart("noTelepon") String noTelepon,
            @RequestPart("kontakDarurat") String kontakDarurat,
            @RequestPart("umur") String umur,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("alamat") String alamat,
            @RequestPart("ktp") MultipartFile ktpRaw,
            @RequestPart("fotoDiri") MultipartFile fotoDiriRaw,
            Model model) {
        try {
            User userCheck = userRepository.findById(
                    Integer.parseInt(nik)).orElse(null);

            if (userCheck != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
            }

            String ktpOrigFilename = StringUtils.cleanPath(ktpRaw.getOriginalFilename());
            String fotoDiriOrigFilename = StringUtils.cleanPath(fotoDiriRaw.getOriginalFilename());

            String ktpExtension = ktpOrigFilename.substring(ktpOrigFilename.lastIndexOf("."));
            String fotoDiriExtension = fotoDiriOrigFilename.substring(ktpOrigFilename.lastIndexOf("."));

            String ktpFilename = "ktp-" + UUID.randomUUID().toString() + ktpExtension;
            String fotoDiriFilename = "fotoDiri-" + UUID.randomUUID().toString() + fotoDiriExtension;

            Path ktpOutDir = Paths.get("/home/abd/Test/VehicRent/uploads/ktp");
            Path fotoDiriOutDir = Paths.get("/home/abd/Test/VehicRent/uploads/foto_diri");

            if (!Files.exists(ktpOutDir)) {
                Files.createDirectories(ktpOutDir);
            }

            if (!Files.exists(fotoDiriOutDir)) {
                Files.createDirectories(fotoDiriOutDir);
            }

            ktpRaw.transferTo(ktpOutDir.resolve(ktpFilename).toFile());
            fotoDiriRaw.transferTo(fotoDiriOutDir.resolve(fotoDiriFilename).toFile());

            Response response = display.Create(new UserRequest(
                    Integer.parseInt(nik),
                    role_user,
                    nama_depan,
                    nama_belakang,
                    noTelepon,
                    kontakDarurat,
                    Integer.parseInt(umur),
                    email,
                    password,
                    alamat,
                    fotoDiriOutDir.resolve(fotoDiriFilename).toString(),
                    ktpOutDir.resolve(ktpFilename).toString()));

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateUser(@RequestBody User Userbaru, @PathVariable Integer id) {
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


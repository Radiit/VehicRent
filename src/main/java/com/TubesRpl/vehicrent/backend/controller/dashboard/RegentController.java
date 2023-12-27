package com.TubesRpl.vehicrent.backend.controller.dashboard;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.RegentRequest;
import com.TubesRpl.vehicrent.backend.payloads.requests.UserRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;
import com.TubesRpl.vehicrent.backend.services.UserServices;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("dashboard/regent")
public class RegentController {
    @Autowired
    private BaseServices<RegentRequest> regentServices;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userServices;

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
            Model model,
            HttpSession session) {
        try {
            User userCheck = userRepository.findById(
                    Integer.parseInt(nik)).orElse(null);

            if (userCheck != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
            }

            String ktpOrigFilename = StringUtils.cleanPath(ktpRaw.getOriginalFilename());
            String fotoDiriOrigFilename = StringUtils.cleanPath(fotoDiriRaw.getOriginalFilename());

            String ktpExtension = ktpOrigFilename.substring(ktpOrigFilename.lastIndexOf("."));
            String fotoDiriExtension = fotoDiriOrigFilename.substring(fotoDiriOrigFilename.lastIndexOf("."));

            String ktpFilename = "ktp-" + UUID.randomUUID().toString() + ktpExtension;
            String fotoDiriFilename = "fotoDiri-" + UUID.randomUUID().toString() +
                    fotoDiriExtension;

            Path ktpOutDir = Paths
                    .get("D:\\code\\java\\dari nizam\\VehicRent\\src\\main\\resources\\static\\img\\uploads\\ktp");
            Path fotoDiriOutDir = Paths.get(
                    "D:\\code\\java\\dari nizam\\VehicRent\\src\\main\\resources\\static\\img\\uploads\\foto_diri");

            if (!Files.exists(ktpOutDir)) {
                Files.createDirectories(ktpOutDir);
            }

            if (!Files.exists(fotoDiriOutDir)) {
                Files.createDirectories(fotoDiriOutDir);
            }

            ktpRaw.transferTo(ktpOutDir.resolve(ktpFilename).toFile());
            fotoDiriRaw.transferTo(fotoDiriOutDir.resolve(fotoDiriFilename).toFile());

            Response response = userServices.Create(new UserRequest(
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
                    ktpOutDir.resolve(ktpFilename).toString(),
                    fotoDiriOutDir.resolve(fotoDiriFilename).toString()));

            if (response.getStatus() != HttpStatus.OK.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            RegentRequest regentBaru = new RegentRequest();
            regentBaru.setNik(Integer.parseInt(nik));

            Response regentResponse = regentServices.Create(regentBaru);

            if (regentResponse.getStatus() != HttpStatus.OK.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(regentResponse);
            }

            session.setAttribute("user", response.getData());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
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

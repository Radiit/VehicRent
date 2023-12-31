package com.TubesRpl.vehicrent.backend.controller.dashboard;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.ClientRequest;
import com.TubesRpl.vehicrent.backend.payloads.requests.RatingRequest;
import com.TubesRpl.vehicrent.backend.payloads.requests.UserRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;
import com.TubesRpl.vehicrent.backend.services.ClientServices;
import com.TubesRpl.vehicrent.backend.services.RatingServices;
import com.TubesRpl.repository.UserRepository;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("dashboard/client")
public class ClientController {

    @Autowired
    ServletContext context;

    @Autowired
    private ClientServices clientServices;

    @Autowired
    private BaseServices<UserRequest> userServices;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingServices ratingServices;

    @Value("${upload.directory}")
    private String uploadDir;

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
            @RequestPart("sim") MultipartFile simRaw,
            Model model) {
        try {
            User userCheck = userRepository.findById(
                    Integer.parseInt(nik)).orElse(null);

            if (userCheck != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
            }

            String ktpOrigFilename = StringUtils.cleanPath(ktpRaw.getOriginalFilename());
            String fotoDiriOrigFilename = StringUtils.cleanPath(fotoDiriRaw.getOriginalFilename());
            String simOrigFilename = StringUtils.cleanPath(simRaw.getOriginalFilename());

            String ktpExtension = ktpOrigFilename.substring(ktpOrigFilename.lastIndexOf("."));
            String fotoDiriExtension = fotoDiriOrigFilename.substring(fotoDiriOrigFilename.lastIndexOf("."));
            String simExtension = simOrigFilename.substring(simOrigFilename.lastIndexOf("."));

            String ktpFilename = "ktp-" + UUID.randomUUID().toString() + ktpExtension;
            String fotoDiriFilename = "fotoDiri-" + UUID.randomUUID().toString() +
                    fotoDiriExtension;
            String simFilename = "sim-" + UUID.randomUUID().toString() +
                    simExtension;

            String absolutePath = context.getRealPath("/");

            Path ktpOutDir = Paths.get(absolutePath + "/../resources/static/public" + "/ktp");
            Path fotoDiriOutDir = Paths.get(absolutePath + "/../resources/static/public" + "/foto_diri");
            Path simOutDir = Paths.get(absolutePath + "/../resources/static/public" + "/sim");

            if (!Files.exists(ktpOutDir)) {
                Files.createDirectories(ktpOutDir);
            }

            if (!Files.exists(fotoDiriOutDir)) {
                Files.createDirectories(fotoDiriOutDir);
            }

            if (!Files.exists(simOutDir)) {
                Files.createDirectories(simOutDir);
            }

            ktpRaw.transferTo(ktpOutDir.resolve(ktpFilename).toFile());
            fotoDiriRaw.transferTo(fotoDiriOutDir.resolve(fotoDiriFilename).toFile());
            simRaw.transferTo(simOutDir.resolve(simFilename).toFile());

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
                    "/resources/public/ktp/" + ktpFilename,
                    "/resources/public/foto_diri/" + fotoDiriFilename));

            if (response.getStatus() != HttpStatus.OK.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            Response clientResponse = clientServices.Create(new ClientRequest(
                    Integer.parseInt(nik),
                    "/resources/public/sim/" + simFilename,
                    null));

            if (clientResponse.getStatus() != HttpStatus.OK.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clientResponse);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
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

}

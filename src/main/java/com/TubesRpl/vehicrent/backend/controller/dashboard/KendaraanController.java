package com.TubesRpl.vehicrent.backend.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Conditional;
// import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import java.util.UUID;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.TubesRpl.vehicrent.backend.payloads.requests.KendaraanRequest;
import com.TubesRpl.vehicrent.backend.payloads.requests.RatingRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;
import com.TubesRpl.vehicrent.backend.services.KendaraanServices;
import com.TubesRpl.vehicrent.backend.services.RatingServices;
import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Rating;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("dashboard/kendaraan")
public class KendaraanController {
    @Autowired
    private BaseServices<KendaraanRequest> display;

    @Autowired
    private KendaraanServices kendaraanServices;
    @Value("${upload.directory}")
    private String uploadDir;

    @Autowired
    ServletContext context;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private KendaraanRepository kendaraanRepository;

    @Autowired
    private RatingServices ratingServices;

    @RequestMapping("/display")
    public ResponseEntity<?> index() {
        Response allkendaraan = display.DisplayAllData();
        return ResponseEntity.status(200).body(allkendaraan);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<?> indexByID(@PathVariable Integer id) {
        Response kendaraanByID = display.DisplayByID(id);
        return ResponseEntity.status(kendaraanByID.getStatus()).body(kendaraanByID);
    }

    @GetMapping("/display/regent/{id}")
    public ResponseEntity<?> indexByRegentID(@PathVariable Integer id) {
        Response kendaraanByID = kendaraanServices.DisplayByRegentID(id);
        return ResponseEntity.status(kendaraanByID.getStatus()).body(kendaraanByID);
    }

    @PostMapping("/create")
    // public ResponseEntity<?> CreateKendaraan(@RequestPart String jenisKendaraan,
    // Model model,
    // HttpSession session) {
    public ResponseEntity<?> CreateKendaraan(
            @RequestPart("jenisKendaraan") String jenisKendaraan,
            @RequestPart("merk") String merk,
            @RequestPart("hargaSewa") String hargaSewa,
            @RequestPart("model") String modelKendaraan,
            @RequestPart("platNomor") String platNomor,
            @RequestPart("warna") String warna,
            @RequestPart("tahunKendaraan") String tahunKendaraan,
            @RequestPart("nomorMesin") String nomorMesin,
            @RequestPart("transmisi") String transmisi,
            @RequestPart("kondisiKendaraan") String kondisiKendaraan,
            @RequestPart("fotoKendaraan") MultipartFile fotoKendaraan,
            @RequestPart("stnkImage") MultipartFile stnkImage,
            Model model,
            HttpSession session) {

        Regent user = (Regent) session.getAttribute("regent");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        KendaraanRequest Kendaraanbaru = new KendaraanRequest();

        Kendaraanbaru.setIdRegent(user.getIdRegent());
        Kendaraanbaru.setJenisKendaraan(jenisKendaraan);
        Kendaraanbaru.setHargaSewa(Integer.parseInt(hargaSewa));
        Kendaraanbaru.setMerkKendaraan(merk);
        Kendaraanbaru.setModel(modelKendaraan);
        Kendaraanbaru.setNomorPlat(platNomor);
        Kendaraanbaru.setWarna(warna);
        Kendaraanbaru.setTahun(Integer.parseInt(tahunKendaraan));
        Kendaraanbaru.setNomorMesin(nomorMesin);
        Kendaraanbaru.setTransmisi(transmisi);
        Kendaraanbaru.setKondisiKendaraan(kondisiKendaraan);

        try {
            String fotoKendaraanOrigFile = fotoKendaraan.getOriginalFilename();
            String fotoKendaraanExt = fotoKendaraanOrigFile.substring(fotoKendaraanOrigFile.lastIndexOf("."));
            String fotoKendaraanNewFile = "vehicle-" + UUID.randomUUID().toString() + fotoKendaraanExt;

            String stnkImageOrigFile = stnkImage.getOriginalFilename();
            String stnkImageExt = stnkImageOrigFile.substring(stnkImageOrigFile.lastIndexOf("."));
            String stnkImageNewFile = "stnk-" + UUID.randomUUID().toString() + stnkImageExt;

            String absolutePath = context.getRealPath("/");

            Path fotoKendaraanOutDir = Paths.get(absolutePath + "/../resources/static/public" + "/kendaraan");
            Path stnkImageOutDir = Paths.get(absolutePath + "/../resources/static/public" + "/stnk");

            if (!Files.exists(fotoKendaraanOutDir)) {
                Files.createDirectories(fotoKendaraanOutDir);
            }

            if (!Files.exists(stnkImageOutDir)) {
                Files.createDirectories(stnkImageOutDir);
            }

            fotoKendaraan.transferTo(fotoKendaraanOutDir.resolve(fotoKendaraanNewFile).toFile());
            stnkImage.transferTo(stnkImageOutDir.resolve(stnkImageNewFile).toFile());

            Kendaraanbaru.setMainImage("/resources/public/kendaraan/" + fotoKendaraanNewFile);
            Kendaraanbaru.setStnk("/resources/public/stnk/" + stnkImageNewFile);

            // return ResponseEntity.status(200).body(Kendaraanbaru);

            Response response = display.Create(Kendaraanbaru);
            if (response.getStatus() == HttpStatus.OK.value()) {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        // Response response = display.Create(Kendaraanbaru);
        // if (response.getStatus() == HttpStatus.OK.value()) {
        // return ResponseEntity.status(HttpStatus.OK).body(response.getData());
        // } else {
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        // }
    }

    @PutMapping("/updatekendaraan/{id}")
    public ResponseEntity<?> UpdateKendaraan(@RequestBody KendaraanRequest Kendaraanbaru, @PathVariable Integer id) {
        Response response = display.Update(id, Kendaraanbaru);
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteKendaraan(@PathVariable Integer id) {
        Response response = display.Delete(id);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> SearchKendaraan(@RequestParam("keyword") String keyword) {
        Response response = kendaraanServices.search(keyword);
        return ResponseEntity.status(200).body(response);
    }

    @RequestMapping("/displayByJenis/{jenis}")
    public ResponseEntity<?> displayByJenis(@PathVariable String jenis) {
        Response kendaraanByJenis = kendaraanServices.DisplayByJenis(jenis);
        return ResponseEntity.status(200).body(kendaraanByJenis);
    }

    @PostMapping("/rate")
    public String giveRating(@RequestParam Integer idKendaraan,
            @RequestParam Integer rating, @RequestParam String comment, Model model, HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            Client client = clientRepository.findByHiddenFalseAndNikClient(user.getNIK_User()).get();
            RatingRequest ratingNew = new RatingRequest();
            ratingNew.setIdKendaraan(idKendaraan);
            ratingNew.setIdClient(client.getIdClient());
            ratingNew.setRating(rating);
            ratingNew.setKomentar(comment);
            ratingServices.giveRating(ratingNew);
            return "redirect:/home/history";
        } catch (Exception e) {
            return "error-page";
        }

    }

    @PutMapping("/rate/edit/{id}")
    public String updateRating(@PathVariable Integer id, @RequestParam int newRating, @RequestParam String komentar,
            Model model, HttpSession session) {
        try {
            RatingRequest rating = new RatingRequest();
            rating.setKomentar(komentar);
            rating.setRating(newRating);
            ratingServices.updateRating(id, rating);
            return "redirect:/home/history";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @PutMapping("/rate/delete/{id}")
    public String deleteRating(@PathVariable Integer id, Model model, HttpSession session) {
        try {
            ratingServices.deleteRating(id);
            return "redirect:/home/history";
        } catch (Exception e) {
            return "error-page";
        }
    }
}

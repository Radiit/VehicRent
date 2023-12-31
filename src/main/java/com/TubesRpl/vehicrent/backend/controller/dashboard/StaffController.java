package com.TubesRpl.vehicrent.backend.controller.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.repository.RegentRepository;
import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.Transaksi;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.StaffRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.ClientServices;
import com.TubesRpl.vehicrent.backend.services.KendaraanServices;
import com.TubesRpl.vehicrent.backend.services.StaffServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("dashboard/staff")
public class StaffController {

    @Autowired
    private StaffServices staffServices;
    @Autowired
    private KendaraanRepository kendaraanRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RegentRepository regentRepository;
    @Autowired
    private KendaraanServices kendaraanServices;
    @Autowired
    private ClientServices clientServices;

    @RequestMapping("/display")
    public ResponseEntity<?> index() {
        Response allStaff = staffServices.DisplayAllData();
        return ResponseEntity.status(200).body(allStaff);
    }

    @RequestMapping("/display/{id}")
    public ResponseEntity<?> displayById(@PathVariable Integer id) {
        Response staffByID = staffServices.DisplayByID(id);
        return ResponseEntity.status(200).body(staffByID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateAccount(@RequestBody StaffRequest staffbaru) {
        Response response = staffServices.Create(staffbaru);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateAccount(@RequestBody StaffRequest staffbaru, @PathVariable Integer id) {
        Response allStaff = staffServices.Update(id, staffbaru);
        return ResponseEntity.status(200).body(allStaff);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id) {
        Response response = staffServices.Delete(id);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // Sesuaikan aja mapping sama return jspnya
    // PAKAI INI BUAT MAPPING
    @RequestMapping("/validasiKendaraan")
    public String validateKendaraan(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole_user().equals("Staff")) {
                    List<Kendaraan> listKendaraan = kendaraanRepository.findAllByHiddenFalseAndValid("Pending");
                    model.addAttribute("listKendaraan", listKendaraan);
                    return "staff/validasi-kendaraan";
                } else {
                    return "redirect:/login";
                }
            } else {
                return "redirect:/login";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    // Sesuaikan aja mapping sama return jspnya
    // PAKAI INI BUAT MAPPING
    @RequestMapping("/validasiUser")
    public String validateUser(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole_user().equals("Staff")) {
                    List<User> listClient = userRepository.findAllByRoleAndValidAndNotHidden("Client", "Pending");
                    List<User> listRegent = userRepository.findAllByRoleAndValidAndNotHidden("Regent", "Pending");
                    // loop to get all client nik
                    List<Integer> listClientNik = new ArrayList<>();
                    for (User user2 : listClient) {
                        listClientNik.add(user2.getNIK_User());
                    }
                    List<Integer> listRegentNik = new ArrayList<>();
                    for (User user2 : listRegent) {
                        listRegentNik.add(user2.getNIK_User());
                    }
                    model.addAttribute("nikRegent", listRegentNik);
                    model.addAttribute("nikClient", listClientNik);
                    model.addAttribute("listRegent", listRegent);
                    model.addAttribute("listClient", listClient);
                    return "staff/validasi-kendaraan";
                } else {
                    return "redirect:/login";
                }
            } else {
                return "redirect:/login";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @RequestMapping("/validasiKendaraan/{id}")
    public String validKendaraan(@RequestParam Boolean status, @PathVariable Integer id, HttpSession session, Model model) {
        try {
            staffServices.validasiKendaraan(id, status);
            return "redirect:/dashboard/staff/validasiKendaraan";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @RequestMapping("/validasiClient/{nik}")
    public String validClient(@RequestParam Boolean status, @PathVariable Integer nik, HttpSession session, Model model) {
        try {
            staffServices.validasiUser(nik, status);
            Client client = clientRepository.findByHiddenFalseAndNikClient(nik).get();
            staffServices.validasiClient(client.getIdClient(), status);
            return "redirect:/dashboard/staff/validasiUser";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @RequestMapping("/validasiRegent/{nik}")
    public String validRegent(@RequestParam Boolean status, @PathVariable Integer nik, HttpSession session, Model model) {
        try {
            staffServices.validasiUser(nik, status);
            Regent regent = regentRepository.findByHiddenFalseAndNikClient(nik).get();
            staffServices.validasiRegent(regent.getIdRegent(), status);
            return "redirect:/dashboard/staff/validasiUser";
        } catch (Exception e) {
            return "error-page";
        }
    }

}

package com.TubesRpl.vehicrent.backend.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.TubesRpl.vehicrent.backend.payloads.requests.KendaraanRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.BaseServices;
import com.TubesRpl.vehicrent.backend.services.KendaraanServices;

@Controller
@RequestMapping("dashboard/kendaraan")
public class KendaraanController {
    @Autowired
    private BaseServices<KendaraanRequest> display;
    @Autowired
    private KendaraanServices kendaraanServices;

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

    @PostMapping("/createkendaraan")
    public ResponseEntity<?> CreateKendaraan(@RequestBody KendaraanRequest Kendaraanbaru, Model model) {
        Response response = display.Create(Kendaraanbaru);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.status(HttpStatus.OK).body(response.getData());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
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
}

package com.TubesRpl.vehicrent.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.repository.RegentRepository;
import com.TubesRpl.repository.StaffRepository;
import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.Staff;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.StaffRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class StaffServices implements BaseServices<StaffRequest> {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RegentRepository regentRepository;

    @Autowired
    private KendaraanRepository kendaraanRepository;

    @Override
    public Response DisplayAllData() {
        List<Staff> allStaff = staffRepository.findAllByHiddenFalse();
        if (allStaff.isEmpty()) {
            return new Response(HttpStatus.NOT_FOUND.value(), "Staff not found", null);
        }
        System.out.println("Display all staff data");
        return new Response(HttpStatus.OK.value(), "Success", allStaff);
    }

    @Override
    public Response Create(StaffRequest request) {
        try {
            User userCheck = userrepository.findByHiddenFalseAndNik(request.getNik()).orElse(null);
            if (userCheck == null) {
                return new Response(HttpStatus.BAD_REQUEST.value(), "User not exist", null);
            }
            Staff staff = new Staff();
            staff.setUser(userCheck);
            staff.setHidden(false);
            staffRepository.save(staff);
            System.out.println("Create new staff with id: " + staff.getIdStaff() + " and NIK: " + staff.getUser().getNIK_User());
            return new Response(HttpStatus.OK.value(), "Success", staff);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Update(Integer id, StaffRequest request) {
        try {
            Staff staff = staffRepository.findById(id).orElse(null);
            if (staff != null) {
                User user = userrepository.findByHiddenFalseAndNik(request.getNik()).orElse(null);
                if (user == null) {
                    return new Response(HttpStatus.NOT_FOUND.value(), "User not found", null);
                }
                staff.setUser(user);
                staff.setHidden(false);
                staffRepository.save(staff);
                System.out.println("Update staff by id : " + id + " and NIK: " + staff.getUser().getNIK_User());
                return new Response(HttpStatus.OK.value(), "Success", staff);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Staff not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id) {
        try {
            Staff staff = staffRepository.findById(id).orElse(null);
            if (staff != null) {
                staff.setHidden(true);
                staffRepository.save(staff);
                System.out.println("Delete staff by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", staff);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Staff Not Found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response DisplayByID(Integer id) {
        try {
            Staff staff = staffRepository.findByHiddenFalseAndIdStaff(id).orElse(null);
            if (staff != null) {
                System.out.println("Display staff by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", staff);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Staff not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response validasiUser(Integer id, boolean valid) {
        try {
            User user = userrepository.findByHiddenFalseAndNik(id).orElse(null);
            if (user != null) {
                user.setValid(valid ? "Valid" : "TidakValid");
                userrepository.save(user);
                System.out.println("Validasi user by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", user);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "User not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response validasiClient(Integer id, boolean valid) {
        try {
            Client client = clientRepository.findByHiddenFalseAndIdClient(id).orElse(null);
            if (client != null) {
                client.setValid(valid ? "Valid" : "TidakValid");
                clientRepository.save(client);
                System.out.println("Validasi client by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", client);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response validasiRegent(Integer id, boolean valid) {
        try {
            Regent regent = regentRepository.findByHiddenFalseAndIdRegent(id).orElse(null);
            if (regent != null) {
                regent.setValid(valid ? "Valid" : "TidakValid");
                regentRepository.save(regent);
                System.out.println("Validasi regent by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", regent);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Regent not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response validasiKendaraan(Integer id, boolean valid) {
        try {
            Kendaraan kendaraan = kendaraanRepository.findByHiddenFalseAndIdKendaraan(id).orElse(null);
            if (kendaraan != null) {
                kendaraan.setValid(valid ? "Valid" : "TidakValid");
                kendaraanRepository.save(kendaraan);
                System.out.println("Validasi kendaraan by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", kendaraan);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

}
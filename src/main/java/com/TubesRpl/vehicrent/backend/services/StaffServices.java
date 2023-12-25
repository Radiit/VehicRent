package com.TubesRpl.vehicrent.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.StaffRepository;
import com.TubesRpl.vehicrent.backend.models.Staff;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.UserRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class StaffServices implements RoleServices<UserRequest> {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private UserServices userServices;

    @Override
    public Response DisplayAllData() {
        List<Staff> allStaff = new ArrayList<>();
        staffRepository.findAll().forEach(allStaff::add);
        for (Staff staff : allStaff) {
            System.out.println("Display all staff data");
        }
        return new Response(HttpStatus.OK.value(), "Success", allStaff);
    }

    @Override
    public Response Create(UserRequest request) {
        try {
            Staff staffCheck = staffRepository.findById(request.getNik()).orElse(null);
            if (staffCheck != null) {
                return new Response(HttpStatus.BAD_REQUEST.value(), "Staff already exist", request);
            }
            Staff staff = new Staff();
            User user = new User();
            user.setNIK_User(request.getNik());
            user.setRole_user(request.getRole_user());
            user.setNama_depan(request.getNama_depan());
            user.setNama_belakang(request.getNama_belakang());
            user.setNoTelepon(request.getNoTelepon());
            user.setKontakDarurat(request.getKontakDarurat());
            user.setUmur(request.getUmur());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            staff.setUser(user);
            staffRepository.save(staff);
            System.out.println("Create new staff");
            return new Response(HttpStatus.OK.value(), "Success", request);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", request);
        }
    }

    @Override
    public Response Update(Integer id, UserRequest request) {
        try {
            Staff staff = staffRepository.findById(id).orElse(null);
            if (staff != null) {
                User user = staff.getUser();
                user.setNIK_User(request.getNik());
                user.setRole_user(request.getRole_user());
                user.setNama_depan(request.getNama_depan());
                user.setNama_belakang(request.getNama_belakang());
                user.setNoTelepon(request.getNoTelepon());
                user.setKontakDarurat(request.getKontakDarurat());
                user.setUmur(request.getUmur());
                user.setEmail(request.getEmail());
                user.setPassword(request.getPassword());
                staff.setUser(user);
                staffRepository.save(staff);
                System.out.println("Update staff by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", staff);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Staff not found", request);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", request);
        }
    }

    @Override
    public Response Delete(Integer id) {
        try {
            Staff staff = staffRepository.findById(id).orElse(null);
            if (staff != null) {
                User user = staff.getUser();
                staffRepository.deleteById(id);
                userServices.Delete(user.getNIK_User());
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
            Staff staff = staffRepository.findById(id).orElse(null);
            if (staff != null) {
                System.out.println("ID Staff: " + staff.getID_Staff());
                System.out.println("NIK User: " + staff.getUser().getNIK_User());
                return new Response(HttpStatus.OK.value(), "Success", staff);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Staff not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }
}

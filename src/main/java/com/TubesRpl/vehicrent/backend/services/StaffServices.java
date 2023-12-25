package com.TubesRpl.vehicrent.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.StaffRepository;
import com.TubesRpl.repository.UserRepository;
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
}

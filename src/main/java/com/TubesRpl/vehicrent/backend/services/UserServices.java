package com.TubesRpl.vehicrent.backend.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.UserRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class UserServices implements BaseServices<UserRequest> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response DisplayAllData() {

        List<User> alluser = userRepository.findAllByHiddenFalse();
        if (alluser.isEmpty()) {
            return new Response(HttpStatus.NOT_FOUND.value(), "No User Found", null);
        }
        System.out.println("Display all user data");
        return new Response(HttpStatus.OK.value(), "Success", alluser);
    }

    @Override
    public Response DisplayByID(Integer id) {
        try {
            User user = userRepository.findByHiddenFalseAndNik(id).orElse(null);
            if (user != null) {
                System.out.println("Display user by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", user);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "User not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Create(UserRequest request) {
        try {
            User userCheck = userRepository.findById(request.getNik()).orElse(null);
            if (userCheck != null) {
                return new Response(HttpStatus.BAD_REQUEST.value(), "User already exist", request);
            }
            User user = new User();
            user.setNIK_User(request.getNik());
            user.setRole_user(request.getRole_user());
            user.setNama_depan(request.getNama_depan());
            user.setNama_belakang(request.getNama_belakang());
            user.setNoTelepon(request.getNoTelepon());

            // ...

            user.setKontakDarurat(request.getKontakDarurat());
            user.setUmur(request.getUmur());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setKtp(request.getKtp());

            // ini nihhh hoowww
            // if (request.getKtp() != null) {
            // try {
            // String directory = "src/main/resources/static/uploads/images/ktp/";
            // String ktpFileName = directory + request.getKtp().getOriginalFilename(); //
            // Ambil nama file

            // File directoryPath = new File(directory);

            // if (!directoryPath.exists()) {
            // directoryPath.mkdirs(); // Buat direktori jika belum ada
            // }

            // File ktpFile = new File(ktpFileName);

            // try {
            // request.getKtp().transferTo(ktpFile); // Simpan file
            // user.setKtp(ktpFileName); // Atur path file pada objek user
            // } catch (IOException e) {
            // e.printStackTrace();
            // }
            // } catch (IOException e) {
            // e.printStackTrace();
            // }
            // }

            user.setFotoDiri(request.getFotoDiri());
            user.setAlamat(request.getAlamat());
            user.setHidden(false);
            user.setValid("Pending");
            userRepository.save(user);
            System.out.println(
                    "Create new user with nik : " + request.getNik() + " and role : " + request.getRole_user());
            return new Response(HttpStatus.OK.value(), "Success", user);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", request);
        }
    }

    @Override
    public Response Update(Integer id, UserRequest request) {
        try {
            User user = userRepository.findByHiddenFalseAndNik(id).orElse(null);
            if (user != null) {
                user.setNIK_User(request.getNik());
                user.setRole_user(request.getRole_user());
                user.setNama_depan(request.getNama_depan());
                user.setNama_belakang(request.getNama_belakang());
                user.setNoTelepon(request.getNoTelepon());
                user.setKontakDarurat(request.getKontakDarurat());
                user.setUmur(request.getUmur());
                user.setEmail(request.getEmail());
                user.setPassword(request.getPassword());
                user.setKtp(request.getKtp());
                user.setFotoDiri(request.getFotoDiri());
                user.setAlamat(request.getAlamat());
                user.setHidden(false);
                user.setValid("Pending");
                userRepository.save(user);
                System.out.println("Update user by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", user);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "User not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id) {
        try {
            User user = userRepository.findById(id).orElse(null);
            if (user != null) {
                user.setHidden(true);
                userRepository.save(user);
                System.out.println("Delete user by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", null);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "User not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

}

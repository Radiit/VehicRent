package com.TubesRpl.vehicrent.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;


@Service
public class UserServices implements BaseServices<User> {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public Response DisplayAllData() {

        List<User> alluser = new ArrayList();
        userRepository.findAll().forEach(alluser::add);
        for (User user : alluser) {
            System.out.println("User ID: " + user.getNIK_User());
            System.out.println("Role User: " + user.getRole_User());
            System.out.println("Nama User: " + user.getNama_User());
            System.out.println("Jenis Kelamin User: " + user.getJenisKelamin_User());
            System.out.println("Umur User: " + user.getUmur_User());
            System.out.println("Email User: " + user.getEmail_User());
        }
        return new Response(HttpStatus.OK.value(), "Success", alluser);
    }

    @Override
    public Response DisplayByID(Integer id){
        try{
            User user = userRepository.findById(id).orElse(null);
            if(user != null){
                System.out.println("User ID: " + user.getNIK_User());
                System.out.println("Role User: " + user.getRole_User());
                System.out.println("Nama User: " + user.getNama_User());
                System.out.println("Jenis Kelamin User: " + user.getJenisKelamin_User());
                System.out.println("Umur User: " + user.getUmur_User());
                System.out.println("Email User: " + user.getEmail_User());
                return new Response(HttpStatus.OK.value(), "Success", user);
            }else{
                return new Response(HttpStatus.NOT_FOUND.value(), "User not found", null);
            }
        }
        catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Create(User model) {
        try{
            userRepository.save(model);
            return new Response(HttpStatus.OK.value(), "Success", model);
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", model);
        }
    }

    @Override
    public Response Update(Integer id, User model) {
        try {
            User user = userRepository.findById(id).orElse(null);
            if (user != null) {
                user.setNIK_User(model.getNIK_User());
                user.setRole_User(model.getRole_User());
                user.setNama_User(model.getNama_User());
                user.setJenisKelamin_User(model.getJenisKelamin_User());
                user.setUmur_User(model.getUmur_User());
                user.setEmail_User(model.getEmail_User());
                user.setUsername(model.getUsername());
                user.setPassword(model.getPassword());
                userRepository.save(user);
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
                userRepository.delete(user);
                return new Response(HttpStatus.OK.value(), "Success", null);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "User not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }
    
}

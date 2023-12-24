package com.TubesRpl.vehicrent.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class AuthServices {

    @Autowired
    private UserRepository userRepository;

    public Response login(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return new Response(HttpStatus.OK, "Login berhasil", user);
        } else {
            return new Response(HttpStatus.BAD_REQUEST, "Email atau password salah", null);
        }
    }
}

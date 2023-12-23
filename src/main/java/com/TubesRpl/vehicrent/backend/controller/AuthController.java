package com.TubesRpl.vehicrent.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @RequestMapping("/login")
    public String showLoginPage(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "index";
            } else {
                return "register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        // Lakukan validasi login dan penanganan sesuai kebutuhan
        // Contoh sederhana:
        if (email.equals("example@email.com") && password.equals("password123")) {
            session.setAttribute("user", email); // Simpan informasi user di session
            return "redirect:/index"; // Redirect ke halaman setelah login sukses
        } else {
            // Tampilkan pesan error jika login gagal
            model.addAttribute("error", "Invalid credentials");
            return "index"; // Kembali ke halaman login
        }
    }

    // Endpoint untuk logout jika diperlukan
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Bersihkan session
        return "redirect:/login"; // Redirect ke halaman login setelah logout
    }

    @GetMapping("/register-form")
    public String showRegisterPage(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "index";
            } else {
                return "register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/register-konfirmasi")
    public String showRegisterKonfirmasi(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "register-konfirmasi";
            } else {
                return "register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/register-regent")
    public String showRegisterRegent(Model model, HttpSession session) {
        try {
            if (session.getAttribute("regent") != null) {
                return "register-regent";
            } else {
                return "register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }
}

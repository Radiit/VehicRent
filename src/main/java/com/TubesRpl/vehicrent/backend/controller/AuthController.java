package com.TubesRpl.vehicrent.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/login")
    public String showLoginPage(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "login";
            } else {
                return "register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @PostMapping("/login")
<<<<<<< HEAD
    public String login(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        // Lakukan validasi login dan penanganan sesuai kebutuhan
        // Contoh sederhana:
        if (email.equals("example@email.com") && password.equals("password123")) {
            session.setAttribute("user", email); // Simpan informasi user di session
            return "redirect:/index"; // Redirect ke halaman setelah login sukses
=======
    public String login(@RequestParam("email") String Email_User,
            @RequestParam("password") String Password,
            Model model, HttpSession session) {

        User user = userRepository.findByEmail(Email_User);

        if (user != null && user.getPassword().equals(Password)) {
            session.setAttribute("user", user);
            return "redirect:/login";
>>>>>>> 11467585cc5fc934af59001d8dec1da8b0a903a8
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login"; // Kembali ke halaman login
        }
    }

    // // Endpoint untuk logout jika diperlukan
    // @GetMapping("/logout")
    // public String logout(HttpSession session) {
    // session.invalidate(); // Bersihkan session
    // return "redirect:/login"; // Redirect ke halaman login setelah logout
    // }

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

<<<<<<< HEAD
    @RequestMapping("/home")
    public String showHome(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "index"; // Change to "index" or the appropriate page if the user is logged in
            } else {
                return "home";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/shop")
    public String showShop(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "login"; // Change to "login" or the appropriate page if the user is logged in
            } else {
                return "shop";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/history")
    public String showHistory(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "login"; // Change to "login" or the appropriate page if the user is logged in
            } else {
                return "history";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/sproduct")
    public String showSproduct(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "login"; // Change to "login" or the appropriate page if the user is logged in
            } else {
                return "sproduct";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/konfirmasi")
    public String showKonfirmasi(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "login"; // Change to "login" or the appropriate page if the user is logged in
            } else {
                return "konfirmasi";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }
=======
    // @GetMapping("/register-konfirmasi")
    // public String showRegisterKonfirmasi(Model model, HttpSession session) {
    // try {
    // if (session.getAttribute("user") != null) {
    // return "register-konfirmasi";
    // } else {
    // return "register-form";
    // }
    // } catch (Exception e) {
    // return "error-page";
    // }
    // }

    // @GetMapping("/register-regent")
    // public String showRegisterRegent(Model model, HttpSession session) {
    // try {
    // if (session.getAttribute("regent") != null) {
    // return "register-regent";
    // } else {
    // return "register-form";
    // }
    // } catch (Exception e) {
    // return "error-page";
    // }
    // }
>>>>>>> 11467585cc5fc934af59001d8dec1da8b0a903a8
}

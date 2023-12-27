package com.TubesRpl.vehicrent.backend.controller;

import org.eclipse.tags.shaded.org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.RegentRepository;
import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private RegentRepository regentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping("/login")
    public String showLoginPage(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                return "redirect:/";
            } else {
                return "/login";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String Email_User,
            @RequestParam("password") String Password,
            Model model, HttpSession session) {

        User user = userRepository.findByEmail(Email_User);

        if (user != null && user.getPassword().equals(Password)) {
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole_user());

            if (user.getRole_user().equals("Regent")) {
                Regent regent = (Regent) regentRepository.findByHiddenFalseAndNikClient(user.getNIK_User()).get();
                session.setAttribute("regent", regent);

                return "redirect:/regent";

            } else if (user.getRole_user().equals("Client")) {
                Client client = (Client) clientRepository.findByHiddenFalseAndNikClient(user.getNIK_User()).get();
                session.setAttribute("client", client);
                return "redirect:/";
            }

            return "redirect:/";

        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login"; // Kembali ke halaman login
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
            if (session.getAttribute("user") == null) {
                return "register-form";
            } else {
                return "login";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/register-konfirmasi")
    public String showRegisterKonfirmasi(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") == null) {
                return "register-konfirmasi";
            } else {
                return "redirect:/register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/register-regent")
    public String showRegisterRegent(Model model, HttpSession session) {
        try {
            if (session.getAttribute("regent") == null) {
                return "register-regent";
            } else {
                return "register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/register-client")
    public String showRegisterClient(Model model, HttpSession session) {
        try {
            if (session.getAttribute("client") == null) {
                return "register-client";
            } else {
                return "register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/register-status")
    public String showRegisterStatus(Model model, HttpSession session) {
        try {
            if (session.getAttribute("status") == "Pending") {
                return "register-status";
            } else if (session.getAttribute("status") == "Valid") {
                return "register-success";
            } else {
                return "register-form";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }
}

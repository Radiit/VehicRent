package com.TubesRpl.vehicrent.backend.controller.dashboard;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TubesRpl.repository.TransaksiRepository;
import com.TubesRpl.vehicrent.backend.models.Transaksi;
import com.TubesRpl.vehicrent.backend.models.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomePageController {
    // @Autowired
    // private List<

    @Autowired
    private TransaksiRepository transaksiRepository;

    @RequestMapping("/home")
    public String homePage(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole_user().equals("Regent") || user.getRole_user().equals("Client")) {
                    return "home";
                } else if (user.getRole_user().equals("Staff")) {
                    return "redirect:/dashboard/staff";
                }
            }

            return "error-page";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole_user().equals("Regent") || user.getRole_user().equals("Client")) {
                    return "home";
                } else if (user.getRole_user().equals("Staff")) {
                    return "redirect:/dashboard/staff";
                }
            } else if (session.getAttribute("user") == null) {
                return "redirect:/login";
            }

            return "error-page";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @RequestMapping("/shop")
    public String shop(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole_user().equals("Regent") || user.getRole_user().equals("Client")) {
                    return "shop";
                } else if (user.getRole_user().equals("Staff")) {
                    return "redirect:/dashboard/staff";
                }
            }

            return "error-page";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @RequestMapping("/history")
    public String history(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole_user().equals("Regent") || user.getRole_user().equals("Client")) {
                    List<Transaksi> transaksi = transaksiRepository.findAllByHiddenFalse();
                    model.addAttribute("listTransaksi", transaksi);
                    return "history";
                } else if (user.getRole_user().equals("Staff")) {
                    return "redirect:/dashboard/staff";
                }
            }

            return "error-page";
        } catch (Exception e) {
            return "error-page";
        }
    }
}

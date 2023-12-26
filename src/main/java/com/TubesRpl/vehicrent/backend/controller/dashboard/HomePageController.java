package com.TubesRpl.vehicrent.backend.controller.dashboard;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.repository.TransaksiRepository;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Transaksi;
import com.TubesRpl.vehicrent.backend.models.User;

import org.springframework.web.bind.annotation.PathVariable;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomePageController {
    // @Autowired
    // private List<

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private KendaraanRepository kendaraanRepository;

    @RequestMapping("/home")
    public String homePage(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole_user().equals("Regent") || user.getRole_user().equals("Client")) {
                    return "client/home";
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
                    return "client/home";
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
                if (user.getRole_user().equals("Regent") ||
                        user.getRole_user().equals("Client")) {
                    return "client/shop";
                } else if (user.getRole_user().equals("Staff")) {
                    return "redirect:/dashboard/staff";
                }
            }
            return "login";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @RequestMapping("/product")
    public String product(Model model, HttpSession session) {
        if (session.getAttribute("selected") != null) {
            Kendaraan kendaraan = (Kendaraan) session.getAttribute("selected");
            model.addAttribute("kendaraan", kendaraan);
        }
        try {
            if (session.getAttribute("user") != null) {
                return "client/sproduct";
            }
            return "redirect:/login";
        } catch (Exception e) {
            return "error-page";
        }

    }

    @RequestMapping("/product/{id}")
    public String showProduct(@PathVariable Integer id, Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                Kendaraan kendaraan = kendaraanRepository.findByHiddenFalseAndIdKendaraan(id).get();
                session.setAttribute("selected", kendaraan);
                return "redirect:/product";
            }
            return "redirect:/login";
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
                    return "client/history";
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

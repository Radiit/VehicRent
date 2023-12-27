package com.TubesRpl.vehicrent.backend.controller.dashboard;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.repository.TransaksiRepository;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.Transaksi;
import com.TubesRpl.vehicrent.backend.models.User;
import com.mysql.cj.log.Log;

import ch.qos.logback.classic.Logger;

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
            return "redirect:/login";
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

    @RequestMapping("/konfirmasi")
    public String konfirmasi(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole_user().equals("Regent") || user.getRole_user().equals("Client")) {
                    return "client/konfirmasi";
                } else if (user.getRole_user().equals("Staff")) {
                    return "redirect:/dashboard/staff";
                }
            }

            return "error-page";
        } catch (Exception e) {
            return "error-page";
        }
    }

    // regent
    @RequestMapping("/regent")
    public String homeRegent(Model model, HttpSession session) {
        return "regent/home-regent";
    }

    @RequestMapping("/list-regent")
    public String regentHistory(Model model, HttpSession session) {
        Regent regent = (Regent) session.getAttribute("regent");

        if (regent == null) {
            return "redirect:/login";
        }

        // List<Kendaraan> kendaraan =
        // kendaraanRepository.findAllByHiddenFalseAndIdRegent(regent.getIdRegent());
        // model.addAttribute("listKendaraan", kendaraan);

        model.addAttribute("idRegent", regent.getIdRegent());

        return "regent/list-regent";
    }

    @RequestMapping("/register-vehicle")
    public String registerVehicle(Model model, HttpSession session) {
        return "regent/register-vehicle";
    }

    @RequestMapping("/history-regent")
    public String productRegent(Model model, HttpSession session) {
        return "regent/history-regent";
    }

    @RequestMapping("/receipt")
    public String receipt(Model model, HttpSession session) {
        Transaksi transaksi = (Transaksi) session.getAttribute("transaksi");

        if (transaksi == null) {
            return "redirect:/history";
        }

        model.addAttribute("transaksi", transaksi);

        return "regent/detailsOrder-regent";
    }

    @RequestMapping("/receipt/{id}")
    public String receiptWithId(@PathVariable Integer id, Model model, HttpSession session) {
        Transaksi transaksi = transaksiRepository.findByHiddenFalseAndIdTransaksi(id).get();

        session.setAttribute("transaksi", transaksi);

        return "redirect:/receipt";
    }

}
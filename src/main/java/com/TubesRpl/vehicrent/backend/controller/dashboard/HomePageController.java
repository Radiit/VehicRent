package com.TubesRpl.vehicrent.backend.controller.dashboard;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

public class HomePageController {
    // @Autowired
    // private List<

    @RequestMapping("/home")
    public String homePage(Model model, HttpSession session) throws SQLException{
        try{
            if(session.getAttribute("user") != null){
                
            }
        }
    }
}

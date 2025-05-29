package com.TubesRpl.vehicrent.backend.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Error implements ErrorController {
    @RequestMapping("/error")
    @ResponseBody
    String error(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (statusCode == null) {
            return "Unknown error";
        }
        
        switch (statusCode) {
            case 404:
                return "404 - Page not found";
            case 403:
                return "403 - Forbidden";
            case 500:
                return "500 - Internal server error";
            default:
                return "Error " + statusCode;
        }
    }
}

package com.xworkz.parking.controller;
import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.xworkz.parking.services.ParkingServices;

@Controller
public class UserController {

	/*
    @Autowired
    private ParkingServices services;

    @PostMapping("/updateProfilePicture")
    public String updateProfilePicture(
            @RequestParam("file") MultipartFile file,
            Principal principal) {
        try {
            String username = principal.getName();
            byte[] newProfilePicture = file.getBytes();
           // services.updateProfilePicture(username, newProfilePicture);
            return "redirect:/profile?success";
        } catch (IOException e) {
            // Handle exception (e.g., log it, show an error page)
            return "redirect:/profile?error";
        }
    }

    // Other methods for handling user login, registration, etc.
     * 
     */
}
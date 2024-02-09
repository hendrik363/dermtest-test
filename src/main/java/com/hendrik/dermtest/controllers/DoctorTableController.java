package com.hendrik.dermtest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendrik.dermtest.models.Doctor;
import com.hendrik.dermtest.services.DoctorsServiceInterface;

@Controller
@RequestMapping("/doctor-table")
public class DoctorTableController {
    
    DoctorsServiceInterface service;

    @Autowired
    public DoctorTableController(DoctorsServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public String displayDoctorTable(Model model) {
        List<Doctor> doctors = service.getDoctors();
        model.addAttribute("doctors", doctors);

        return "doctor-table";
    } 
}

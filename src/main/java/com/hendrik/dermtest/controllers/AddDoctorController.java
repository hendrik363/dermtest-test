package com.hendrik.dermtest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendrik.dermtest.models.Doctor;
import com.hendrik.dermtest.services.DoctorsServiceInterface;

@Controller
@RequestMapping("/add-doctor")
public class AddDoctorController {

    DoctorsServiceInterface service;

    @Autowired
    public AddDoctorController(DoctorsServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public String displayAddDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());

        return "add-doctor";
    } 
    
    @PostMapping
    public String addDoctorForm(@Valid Doctor newDoctor, BindingResult bindingResult, Model model) {

        service.addDoctor(newDoctor);

        return "redirect:/";
    }


}

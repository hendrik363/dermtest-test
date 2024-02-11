package com.hendrik.dermtest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendrik.dermtest.models.Doctor;
import com.hendrik.dermtest.services.DoctorsServiceInterface;


@Controller
@RequestMapping("/update-doctor/{id}")
public class UpdateDoctorController {
    DoctorsServiceInterface service;

    @Autowired
    public UpdateDoctorController(DoctorsServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public String displayDoctorUpdateForm(@PathVariable Long id,Model model) {
        Doctor doctor = service.getById(id);

        model.addAttribute("doctor", doctor);

        return "update-doctor";
    } 

    @PostMapping
    public String updateDoctor(@Valid Doctor updateDoctor,@PathVariable Long id, BindingResult bindingResult, Model model) {

        System.out.println("UPDATEDOCTOR: " + updateDoctor);

        service.updateDoctor(id, updateDoctor);

        return "redirect:/doctor-table";
    }
    


}

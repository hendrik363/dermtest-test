package com.hendrik.dermtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hendrik.dermtest.models.Doctor;
import com.hendrik.dermtest.services.DoctorsServiceInterface;

@Controller
@RequestMapping("/delete-doctor/{id}")
public class DeleteDoctorController {
    DoctorsServiceInterface service;

    @Autowired
    public DeleteDoctorController(DoctorsServiceInterface service) {
        this.service = service;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteDoctor(@PathVariable Long id,Model model) {
        service.deleteDoctor(id);

        return "redirect:/doctor-table";
    }
}

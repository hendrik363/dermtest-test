package com.hendrik.dermtest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hendrik.dermtest.models.Doctor;
import com.hendrik.dermtest.services.DoctorsServiceInterface;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorsRestController {


    DoctorsServiceInterface service;

    @Autowired
    public DoctorsRestController(DoctorsServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public List<Doctor> getDoctors() {
        List<Doctor> doctors = service.getDoctors();

        return doctors;
    }

    @GetMapping("/search/{search}")
    public List<Doctor> searchDoctors(@PathVariable String search) {
        List<Doctor> doctors = service.searchDoctors(search);

        return doctors;
    }

    @PostMapping
    public ResponseEntity<Long> addDoctor(@Valid @RequestBody Doctor doctor, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Long id = service.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable(name="id") Long id) {
        return service.getById(id);
    }

    @PostMapping("/delete/{id}")
    public boolean deleteDoctor(@PathVariable(name="id") Long id) {
        return service.deleteDoctor(id);
    }

    @PutMapping("/update/{id}")
    public Doctor updateDoctor(@RequestBody Doctor doctor, @PathVariable(name="id") Long id) {
        return service.updateDoctor(id, doctor);
    }

}

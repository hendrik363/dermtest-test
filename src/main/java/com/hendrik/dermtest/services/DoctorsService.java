package com.hendrik.dermtest.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hendrik.dermtest.data.DoctorsDataInterface;
import com.hendrik.dermtest.models.Doctor;

public class DoctorsService implements DoctorsServiceInterface {

    @Autowired
    DoctorsDataInterface doctorsDAO;

    private static final Logger logger = LoggerFactory.getLogger(DoctorsService.class);

    @Override
    public List<Doctor> getDoctors() { 
        return doctorsDAO.findAll();
    }

    @Override
    public Doctor getById(Long id) {
        
        try {
            logger.info("Searching doctor by Id.");
            return doctorsDAO.findById(id).orElseThrow(() -> new NoSuchElementException("No Doctor found with id: " + id));
        } catch (Exception e) {
            logger.info("No Doctors with this id.");
            return null;
        }
    }

    @Override
    public List<Doctor> searchDoctors(String search) {
        List<Doctor> foundDoctors = doctorsDAO.findAll().stream().filter(doctor -> doctor.getDoctorName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());

        if(foundDoctors.isEmpty()) {
            logger.info("Search term does not match any doctor.");
        }
        
        return foundDoctors;
    }

    @Override
    public Long addDoctor(Doctor newDoctor) {
        Doctor savedDoctor = doctorsDAO.save(newDoctor);

        logger.info("Added Doctor with id: {}", savedDoctor.getId());
        
        return savedDoctor.getId();
    }

    @Override
    public boolean deleteDoctor(Long id) {
        try {
            doctorsDAO.deleteById(id);
            logger.info("Deleted doctor with id: {}", id);
            return true;
        } catch (Exception e) {
            logger.error("No Doctor matches id: {}", id);
            return false;
        }
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor updateDoctor) {
    Doctor existingDoctor = doctorsDAO.findById(id).orElse(null);

    if (existingDoctor != null) {
        existingDoctor.setDoctorName(updateDoctor.getDoctorName());
        existingDoctor.setSpecialization(updateDoctor.getSpecialization());
        existingDoctor.setBirthDate(updateDoctor.getBirthDate());
        existingDoctor.setEmail(updateDoctor.getEmail());
        existingDoctor.setPhoneNumber(updateDoctor.getPhoneNumber());

        logger.info("Doctor updated.");
        return doctorsDAO.save(existingDoctor);
    } else {
        logger.error("There is no doctor with this id: {}", id);
        return null;
    }
    }
    
}

package com.hendrik.dermtest.services;

import java.util.List;

import com.hendrik.dermtest.models.Doctor;

public interface DoctorsServiceInterface {

    public Doctor getById(Long id);
    public List<Doctor> getDoctors();
    public List<Doctor> searchDoctors(String search);
    public Long addDoctor(Doctor newDoctor);
    public boolean deleteDoctor(Long id);
    public Doctor updateDoctor(Long id, Doctor updateDoctor);
}

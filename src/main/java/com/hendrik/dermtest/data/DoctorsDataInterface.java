package com.hendrik.dermtest.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendrik.dermtest.models.Doctor;

@Repository
public interface DoctorsDataInterface extends JpaRepository<Doctor, Long> {
    
}

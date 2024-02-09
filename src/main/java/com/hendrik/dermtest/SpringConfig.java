package com.hendrik.dermtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hendrik.dermtest.services.DoctorsService;
import com.hendrik.dermtest.services.DoctorsServiceInterface;

@Configuration
public class SpringConfig {
    
    @Bean(name="doctorsService")
    public DoctorsServiceInterface getDoctors() {
        return new DoctorsService();
    }
}

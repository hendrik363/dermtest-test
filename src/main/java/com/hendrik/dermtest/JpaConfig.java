package com.hendrik.dermtest;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.hendrik")
public class JpaConfig {
    
}

package com.springLearning.config;

import com.springLearning.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    Vehicle vehicle(){
        var v = new Vehicle();
        v.setName("Porche 911");
        return v;
    }
}

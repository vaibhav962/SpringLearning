package com.springLearning.config;

import com.springLearning.beans.Person;
import com.springLearning.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springLearning.beans")
public class ProjectConfig {
    @Bean("maserati")
    Vehicle vehicle(){
        var v = new Vehicle();
        v.setName("Maserati MC20");
        return v;
    }

    @Bean(name = "porche")
    Vehicle vehicle1(){
        var v = new Vehicle();
        v.setName("Porche 911");
        return v;
    }
//
//    @Bean("arthur")
//    Person person(Vehicle v){
//        var p = new Person();
//        p.setName("Arthur");
//        p.setVehicle(v);
//        return p;
//    }
}

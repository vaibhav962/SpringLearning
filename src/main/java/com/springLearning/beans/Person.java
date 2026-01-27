package com.springLearning.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;

    private final Vehicle vehicle;

    @Autowired //optional if only one constructor
    public Person(Vehicle vehicle) {
        System.out.println("Person bean created");
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

//    @Autowired
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    @PostConstruct
    public void initialize(){
        this.name = "Arthur";
    }
}

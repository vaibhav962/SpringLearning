package com.springLearning.main;

import com.springLearning.beans.Vehicle;
import com.springLearning.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        v1.setName("Bugatti Chiron");
        System.out.println("From non-spring context:" + v1.getName());

        //to initialize the Spring IOC Container
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v2 = context.getBean(Vehicle.class);
        System.out.println("From spring context:" + v2.getName());
    }
}

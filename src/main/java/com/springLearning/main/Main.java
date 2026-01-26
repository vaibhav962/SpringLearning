package com.springLearning.main;

import com.springLearning.beans.Vehicle;
import com.springLearning.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Vehicle v1 = new Vehicle();
//        v1.setName("Bugatti Chiron");
//        System.out.println("From non-spring context:" + v1.getName());

        //to initialize the Spring IOC Container
//        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        //passing name parameter to avoid ambiguity
//        Vehicle v1 = context.getBean("porche",Vehicle.class);
//        Vehicle v2 = context.getBean("lamborghini",Vehicle.class);

        //if no name is passed, @Primary bean will be used
//        Vehicle v3 = context.getBean(Vehicle.class);
//        System.out.println("From spring context:\n" + v1.getName() + "\n" + v2.getName() + "\n" + v3.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v = context.getBean(Vehicle.class);
        System.out.println("Component Vehicle name from Spring Context is: " + v.getName());
        v.printHello();
        context.close();
    }
}

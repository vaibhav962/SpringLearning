package com.springLearning.main;

import com.springLearning.beans.Vehicle;
import com.springLearning.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

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
        Vehicle porche = new Vehicle();
        porche.setName("Porche 911");
        Supplier<Vehicle> porcheSupplier = () -> porche;

        Supplier<Vehicle> lamborghiniupplier = () -> {
            Vehicle lamborghini = new Vehicle();
            lamborghini.setName("Lamborghini Sián");
            return lamborghini;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = " + randomNumber);

        if((randomNumber% 2) == 0){
            context.registerBean("porche",
                    Vehicle.class,porcheSupplier);
        }else{
            context.registerBean("lamborghini",
                    Vehicle.class,lamborghiniupplier);
        }
        Vehicle porcheVehicle = null;
        Vehicle lamborghiniVehicle = null;
        try {
            porcheVehicle = context.getBean("porche",Vehicle.class);
        }catch (NoSuchBeanDefinitionException e){
            System.out.println("Error while creating Porche vehicle");
        }
        try {
            lamborghiniVehicle = context.getBean("lamborghini",Vehicle.class);
        }catch (NoSuchBeanDefinitionException e){
            System.out.println("Error while creating Lamborghini vehicle");
        }

        if(porcheVehicle != null){
            System.out.println("Programming Vehicle name from Spring Context is: " + porcheVehicle.getName());
        }else if(lamborghiniVehicle != null){
            System.out.println("Programming Vehicle name from Spring Context is: " + lamborghiniVehicle.getName());
        }
    }
}

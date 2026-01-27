package com.springLearning.main;

import com.springLearning.beans.Person;
import com.springLearning.beans.Vehicle;
import com.springLearning.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person p = context.getBean(Person.class);
//        Vehicle v = context.getBean(Vehicle.class);

        System.out.println(p.getName() + " owns " +p.getVehicle().getName());

    }
}

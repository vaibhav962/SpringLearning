package com.springLearning.main;

import com.springLearning.beans.Person;
import com.springLearning.beans.Vehicle;
import com.springLearning.config.ProjectConfig;
import com.springLearning.model.Song;
import com.springLearning.services.VehicleServices;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehicleServices = context.getBean(VehicleServices.class);
        System.out.println(vehicleServices.getClass());
        Song song = new Song();
        song.setTitle("9");
        song.setSingerName("Drake");
        boolean vehicleStarted = true;
        String moveVehicleStatus = vehicleServices.moveVehicle(vehicleStarted);
        String playMusicStatus = vehicleServices.playMusic(vehicleStarted,song);
        String applyBrakeStatus = vehicleServices.applyBrake(vehicleStarted);
    }
}

package com.springLearning.services;

import com.springLearning.interfaces.Speakers;
import com.springLearning.interfaces.Tyres;
import com.springLearning.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class VehicleServices {

    private Logger logger = Logger.getLogger(VehicleServices.class.getName());

    @Autowired
    private Speakers speakers;
    private Tyres tyres;

    public String playMusic(boolean vehicleStarted, Song song){
        String music = null;
        if(vehicleStarted){
            music = speakers.makeSound(song);
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" + " operation");
        }
        return music;
    }

    public String moveVehicle(boolean vehicleStarted){
       String status = null;
        if(vehicleStarted){
            status = tyres.rotate();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" + " operation");
        }
        return status;
    }

    public String applyBrake(boolean vehicleStarted){
        String status = null;
        if(vehicleStarted){
            status = tyres.stop();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" + " operation");
        }
        return status;
    }


    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}

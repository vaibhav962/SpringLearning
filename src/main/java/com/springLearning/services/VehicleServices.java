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
        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted){
        return tyres.rotate();
    }

    public String applyBrake(boolean vehicleStarted){
        return tyres.stop();
    }


    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}

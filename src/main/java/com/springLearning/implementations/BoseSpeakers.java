package com.springLearning.implementations;

import com.springLearning.interfaces.Speakers;
import com.springLearning.model.Song;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {
    @Override
    public String makeSound(Song song) {
        return "Bose...";
    }
}

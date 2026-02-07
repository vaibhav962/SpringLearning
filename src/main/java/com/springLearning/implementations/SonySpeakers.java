package com.springLearning.implementations;

import com.springLearning.interfaces.Speakers;
import com.springLearning.model.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {

    @Override
    public String makeSound(Song song) {
        return "Sony...";
    }
}

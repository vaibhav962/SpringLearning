package com.springLearning.implementations;

import com.springLearning.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class TypeBTyres implements Tyres {

    @Override
    public String rotate() {
        return "Rotating: Type B";
    }

    @Override
    public String stop() {
        return "Stopped: Type B";
    }
}

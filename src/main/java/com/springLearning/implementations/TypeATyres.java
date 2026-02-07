package com.springLearning.implementations;

import com.springLearning.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TypeATyres implements Tyres {

    @Override
    public String rotate() {
        return "Rotating: Type A";
    }

    @Override
    public String stop() {
        return "Stopped: Type A";
    }
}

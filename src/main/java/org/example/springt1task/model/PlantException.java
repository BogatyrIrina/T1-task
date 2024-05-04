package org.example.springt1task.model;

import org.example.springt1task.annotation.Throw;

@Throw
public class PlantException extends RuntimeException {

    public PlantException() {
    }

    public PlantException(String message){
        super(message);
    }
}

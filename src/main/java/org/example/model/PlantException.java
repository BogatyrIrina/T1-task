package org.example.model;

import org.example.annotation.Throw;

@Throw
public class PlantException extends RuntimeException {

    public PlantException() {
    }

    public PlantException(String message){
        super(message);
    }
}

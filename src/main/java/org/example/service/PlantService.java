package org.example.service;

import org.example.model.Plant;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlantService {

    private final Map<String, Plant> plants = new HashMap<>();

    public void addPlant(Plant plant){
        plants.put(plant.getName(), plant);
    }

    public void addPlants(List<Plant> newPlants){
        plants.putAll(newPlants.stream().collect(Collectors.toList()));
    }
}

package org.example.service;

import org.example.annotation.Asynchronously;
import org.example.model.Plant;
import org.example.model.PlantException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PlantService {

    private final Map<String, Plant> plants = new HashMap<>();

    @Asynchronously
    public void addPlant(Plant plant){
        plants.put(plant.getName(), plant);
    }

    @Asynchronously
    public void addPlants(List<Plant> newPlants){
        if (newPlants.size() ==1){
            throw new PlantException("Используйте метод addPlant(Plant plant)");
        }
        plants.putAll(newPlants.stream().collect(Collectors.toMap(Plant::getName, Function.identity())));
    }

    public Plant getPlantByName(String name) {
        return plants.get(name);
    }

    public List<Plant> getPlantByType(String type) {
        return plants.values().stream().filter(plant -> plant.getType().equals(type)).collect(Collectors.toList());
    }
}

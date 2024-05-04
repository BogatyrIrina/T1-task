package org.example.springt1task.service;

import org.example.springt1task.annotation.Asynchronously;
import org.example.springt1task.annotation.PreInvoke;
import org.example.springt1task.annotation.SuccessLogging;
import org.example.springt1task.annotation.Valid;
import org.example.springt1task.model.Plant;
import org.example.springt1task.model.PlantException;
import org.example.springt1task.model.RoleType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@SuccessLogging
public class PlantService {

    private final Map<String, Plant> plants = new HashMap<>();

    @Asynchronously
    @PreInvoke(roles = RoleType.ADMIN)
    public void addPlant(@Valid Plant plant){
        plants.put(plant.getName(), plant);
    }

    @Asynchronously
    @PreInvoke(roles = RoleType.ADMIN)
    public void addPlants(@Valid List<Plant> newPlants){
        if (newPlants.size() ==1){
            throw new PlantException("Используйте метод addPlant(Plant plant)");
        }
        plants.putAll(newPlants.stream().collect(Collectors.toMap(Plant::getName, Function.identity())));
    }

    @PreInvoke(roles = {RoleType.ADMIN, RoleType.USER})
    public Plant getPlantByName(String name) {
        return plants.get(name);
    }

    @PreInvoke(roles = {RoleType.ADMIN, RoleType.USER})
    public List<Plant> getPlantByType(String type) {
        return plants.values().stream().filter(plant -> plant.getType().equals(type)).toList();
    }
}

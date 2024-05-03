package org.example;

import lombok.RequiredArgsConstructor;
import org.example.model.Info;
import org.example.model.Plant;
import org.example.service.PlantService;
import org.example.utils.ThreadUtils;
import org.example.utils.UserContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.net.SocketTimeoutException;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringT1TaskApplication {

//    private final Info info;

    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(SpringT1TaskApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady(){
//        info.info();

        UserContext.setUsername("user");
        plantService.addPlant(new Plant("Роза", "Цветок"));

        ThreadUtils.waitTime(200);

        System.out.println(plantService.getPlantByType("Цветок"));
        System.out.println(plantService.getPlantByName("Роза"));

        ThreadUtils.waitTime(200);
        plantService.addPlants(List.of(new Plant("Кукуруза", "Трава"),
                new Plant("Дуб", "Дерево")));
    }
}
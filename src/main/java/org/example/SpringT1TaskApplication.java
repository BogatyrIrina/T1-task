package org.example;

import lombok.RequiredArgsConstructor;
import org.example.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringT1TaskApplication {

    private final Info info;

    public static void main(String[] args) {
        SpringApplication.run(SpringT1TaskApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady(){
        info.info();
    }
}
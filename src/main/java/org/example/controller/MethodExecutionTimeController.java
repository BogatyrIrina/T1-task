package org.example.controller;

import org.example.service.impl.MethodExecutionTimeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/method-execution-times")
public class MethodExecutionTimeController {
    private final MethodExecutionTimeServiceImpl methodExecutionTimeService;

    public MethodExecutionTimeController(MethodExecutionTimeServiceImpl methodExecutionTimeService) {
        this.methodExecutionTimeService = methodExecutionTimeService;
    }

    @GetMapping("/average")
    public ResponseEntity<Map<String, Double>> getAverageExecutionTimes() {
        Map<String, Double> averageExecutionTimes = methodExecutionTimeService.getAverageExecutionTimes();
        return ResponseEntity.ok(averageExecutionTimes);
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Long>> getTotalExecutionTimes() {
        Map<String, Long> totalExecutionTimes = methodExecutionTimeService.getTotalExecutionTimes();
        return ResponseEntity.ok(totalExecutionTimes);
    }
}

package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.repository.MethodExecutionTimeRepository;
import org.example.service.MethodExecutionTimeService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MethodExecutionTimeServiceImpl implements MethodExecutionTimeService {
    private final MethodExecutionTimeRepository methodExecutionTimeRepository;


    @Override
    public void saveExecutionTime(String methodSignature, long executionTime) {

    }

    @Override
    public Map<String, Double> getAverageExecutionTimes() {
        return Map.of();
    }

    @Override
    public Map<String, Long> getTotalExecutionTimes() {
        return Map.of();
    }
}

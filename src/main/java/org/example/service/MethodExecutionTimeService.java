package org.example.service;

import java.util.Map;

public interface MethodExecutionTimeService {
    void saveExecutionTime(String methodSignature, long executionTime);
    //метод для получения средних времен выполнения методов
    Map<String, Double> getAverageExecutionTimes();
    //метод для получения общих времен выполнения методов
    Map<String, Long> getTotalExecutionTimes();
}

package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.service.impl.MethodExecutionTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionTimeAspect {
    @Autowired
    private MethodExecutionTimeServiceImpl methodExecutionTimeService;

    @Around("@annotation(TrackTime)")
    public Object trackTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        methodExecutionTimeService.saveExecutionTime(joinPoint.getSignature().toShortString(), executionTime);
        return result;
    }

    @Async
    @Around("@annotation(TrackAsyncTime)")
    public void trackAsyncTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        methodExecutionTimeService.saveExecutionTime(joinPoint.getSignature().toShortString(), executionTime);
    }
}

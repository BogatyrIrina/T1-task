package org.example.springt1task.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Aspect
@Slf4j
public class AsyncRunnerAspect {

    @Pointcut("execution(@org.example.springt1task.annotation.Asynchronously public void add*(..))")
    public void asyncRunnerPointcut(){
    }

    @Around("asyncRunnerPointcut()")
    public Object asyncRunner(ProceedingJoinPoint joinPoint) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Асинхронный запуск в asyncRunnerPointcut");
                joinPoint.proceed();
            } catch (Throwable e) {
                log.error("Ошибка asyncRunnerPointcut", e);
            }
        });
    }
}

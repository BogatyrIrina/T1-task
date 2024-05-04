package org.example.springt1task.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@Order(1)
public class ExceptionHandlerAspect {

    @AfterThrowing(pointcut = "withing(org.example.springt1task.service.*) &&" +
            " execution(* * (..)) throws @org.example.springt1task.annotation.Throw *)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        log.info("Произошла ошибка при вызове метода {}", joinPoint.getSignature().toShortString());
        log.info("Ошибка: {}", exception.getMessage());
    }
}

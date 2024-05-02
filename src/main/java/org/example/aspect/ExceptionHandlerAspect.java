package org.example.aspect;

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

    @AfterThrowing(pointcut = "withing(com.example.springt1task.service.*) &&" +
            " execution(* * (..)) throws @com.example.springt1task.annotation.Throw *)", throwing = "exeption")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        log.info("Произошла ошибка при вызове метода {}", joinPoint.getSignature().toShortString());
        log.info("Ошибка: {}", exception.getMessage());
    }
}

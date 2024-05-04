package org.example.springt1task.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
@Slf4j
public class SuccessLoggingAspect {

    @AfterReturning(" withing(org.example.springt1task.service.*) && " +
            "@withing(org.example.springt1task.annotation.SuccessLogging)")
    public void successLogging(JoinPoint joinPoint){
        log.info("Метод успешно выполнился: {}", joinPoint.getSignature().toLongString());
        log.info("------------------------------");
    }
}

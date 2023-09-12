package com.spring.aop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
@Log4j2
public class FirstAspect {
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void isController() {
    }

    @Pointcut("isController() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {
    }

    @Before("hasGetMapping()")
    public void addLoggingBefore(JoinPoint jp) {
        String param = Arrays.toString(jp.getArgs());
        log.info("Входящие параметры: " + param);
    }

    @AfterReturning(pointcut = "hasGetMapping()", returning = "result")
    public void addLoggingAfter(Object result) {
        log.info("Результат выполнения метода: " + result.toString());
    }


}

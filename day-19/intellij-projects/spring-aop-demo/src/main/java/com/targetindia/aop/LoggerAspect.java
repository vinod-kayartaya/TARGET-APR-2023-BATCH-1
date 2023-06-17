package com.targetindia.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    public LoggerAspect() {
        log.trace("LoggerAspect constructor called");
    }

    // advice to be applied BEFORE entering any method of ProductDao object
    //@Before("execution(* com.targetindia.dao.*Dao.*(..))")
    @Before("execution(* com.targetindia..*Dao*.*(..))")
    public void logBeforeExecutionOfTargetMethod(JoinPoint jp){
        log.trace("entering {}.{}() method with {} parameters",
                jp.getTarget().getClass().getName(),
                jp.getSignature().getName(),
                jp.getArgs().length==0 ? "no": Arrays.asList(jp.getArgs())
                );
    }

    @AfterReturning(pointcut="execution(* com.targetindia..*Dao*.*(..))", returning = "retVal")
    public void logAfter(JoinPoint jp, Object retVal){
        if(retVal==null){
            log.trace("exiting from {}.{}() method",
                    jp.getTarget().getClass().getName(),
                    jp.getSignature().getName());
            return;
        }
        if(retVal instanceof Collection<?>){
            Collection<?> coll = (Collection<?>) retVal;
            log.trace("exiting from {}.{}() method with a collection consisting of {} elements",
                    jp.getTarget().getClass().getName(),
                    jp.getSignature().getName(),
                    coll.size());
        }
        else if(retVal instanceof Map<?,?>){
            Map<?,?> map = (Map<?,?>) retVal;
            log.trace("exiting from {}.{}() method with a map consisting of {} entry",
                    jp.getTarget().getClass().getName(),
                    jp.getSignature().getName(),
                    map.size());
        }
        else {
            log.trace("exiting from {}.{}() method with a return value - {}",
                    jp.getTarget().getClass().getName(),
                    jp.getSignature().getName(),
                    retVal);
        }

    }
}

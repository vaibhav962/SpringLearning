package com.springLearning.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {
    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());
    @Around("execution(* com.springLearning.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
        logger.info(joinPoint.getSignature().toString() + " method execution end");
    }

    @AfterThrowing(value = "execution(* com.springLearning.services.*.*(..))",throwing = "e")
   public void logException(JoinPoint joinPoint, Exception e){
        logger.log(Level.SEVERE, joinPoint.getSignature() + " An exception was thrown with the help of @AfterThrowing which happened due to: "+e.getMessage());
   }

    @AfterReturning(value = "execution(* com.springLearning.services.*.*(..))",returning = "val")
    public void logStatus(JoinPoint joinPoint, Object val){
        logger.log(Level.INFO, joinPoint.getSignature() + " Method successfully processed with the status of: "+ val.toString());
    }
}

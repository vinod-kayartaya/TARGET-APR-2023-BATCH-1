package com.targetindia.aop;

import com.targetindia.dao.DaoException;
import com.targetindia.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class TransformerAspect {

    @AfterThrowing(pointcut = "execution(* com.tar*..*Dao.*(..))", throwing = "ex")
    public void convertToDaoException(Exception ex) throws DaoException {
        throw new DaoException(ex);
    }

    @Around("execution(* com.tar*..ProductDao.*(double, double))")
    public Object swapArgs(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        log.trace("BEFORE: inside TransformerAspect.swapArgs, args = {}", Arrays.toString(args));
        double a = (double) args[0];
        double b = (double) args[1];
        if(a>b){
            args = new Object[]{b, a};
        }
        Object retVal = jp.proceed(args); // asking proxy to carry a different set of arguments t the target method
        log.trace("AFTER: inside TransformerAspect.swapArgs, args = {}", Arrays.toString(args));
        return retVal;
    }

    @Before("execution(* com.tar*..ProductDao.*(com.targetindia.entity.Product))")
    public void convertProductNameToProperCase(JoinPoint jp){
        Product p1 = (Product) jp.getArgs()[0];
        log.trace("BEFORE: inside TransformerAspect.convertProductNameToProperCase(), p1={}", p1);
        String name = p1.getProductName();
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
        p1.setProductName(name);
        log.trace("AFTER: inside TransformerAspect.convertProductNameToProperCase(), p1={}", p1);
    }
}

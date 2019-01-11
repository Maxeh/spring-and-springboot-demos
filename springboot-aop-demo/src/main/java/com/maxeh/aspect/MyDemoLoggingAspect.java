package com.maxeh.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.maxeh.aspect.Pointcuts.forDaoPackageNoGetterSetter()")
    public void performLogging() {
        System.out.println("Perform logging.");
    }
}

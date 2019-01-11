package com.maxeh.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {
    @Before("com.maxeh.aspect.Pointcuts.forDaoPackageNoGetterSetter()")
    public void performCloudLogging() {
        System.out.println("Perform cloud logging.");
    }
}

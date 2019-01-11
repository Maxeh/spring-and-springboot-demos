package com.maxeh.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Pointcuts {

    // Other useful pointcuts:
    // Call on specific method: @Before("execution(public * com.maxeh.dao.AccountDAO.addAccount())")
    // Call on specific method: @Before("execution(* addAccount())")

    // Call on every class and every method:
    @Pointcut("execution(public * com.maxeh.dao.*.*(..))")
    public void forDaoPackage() {}

    // Pointcut for getter methods
    @Pointcut("execution(public * com.maxeh.dao.*.get*(..))")
    public void getterPointcut() {}

    // Pointcut for setter methods
    @Pointcut("execution(public * com.maxeh.dao.*.set*(..))")
    public void setterPointcut() {}

    // Combined pointcut: include package and exclude getter / setter
    @Pointcut("forDaoPackage() && !(getterPointcut() || setterPointcut())")
    public void forDaoPackageNoGetterSetter() {}
}

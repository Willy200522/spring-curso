package com.william.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class RequirementsDB {

    @Before("com.william.aop.aspects.LoginClass.forClients()")
    public void tableRequeriments(){

        System.out.println("4 -- La tabla todavía no tiene 3mil registros para cumplir los requisitos");

    }
}

package com.william.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginClass {

    //-> Declaramos la anotación pointcut expression para reutilizarlo,
    // Debajo tiene que tener un nombre identificativo y una acción vacia

    @Pointcut("execution(public * insertClient*())")
    private void forClients(){}

    // De forma dura -> @Before("execution(public * com.william.aop.dao.ClientVipDAO.insertClient*())")
    // Reutilizable ->

    @Before("forClients()")
    public void beforeInsert(){
        System.out.println("Verificando logueo antes de insertar el cliente");

        System.out.println("Login correcto");

    }

    @Before("forClients()")
    void requirements(){
        System.out.println("El cliente cumple los requisitos para la inserción");
    }

    @Before("forClients()")
    void tableRequeriments(){
        System.out.println("La tabla todavía no tiene 3mil registros para cumplir los requisitos");
    }
}
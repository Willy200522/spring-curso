package com.william.aop.aspects;

import com.william.aop.dao.ClientDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class RequirementsClient {

    @Before("com.william.aop.aspects.LoginClass.forClients()")
    //Normal public void requirements(){
    public void requirements(JoinPoint myJoin){

        System.out.println("3 -- El cliente cumple los requisitos para la inserción");

        Object[] args = myJoin.getArgs();

        for (Object arg : args){

            if (arg instanceof ClientDAO) {

                System.out.print("3 -- hay: " + ++count + " instancias de Clientes");

            }

            System.out.println(". -- argurmentos encontrados: " + arg);

        }
    }

    int count=0;
}

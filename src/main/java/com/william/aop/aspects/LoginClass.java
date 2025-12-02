package com.william.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


// 1era clase de aspectos
/*
@Aspect
@Component
public class LoginClass {

    //-> Declaramos la anotación pointcut expression para reutilizarlo,
    // Debajo tiene que tener un nombre identificativo y una acción vacia
    //@Pointcut("execution(public * insertClient*())") -> forma tradicional


    // -> Para que haga efecto este pointcut en un paquete completo ya que pueden haber varios métodos
    // distribuidos, se usa el comodín ".." para indicar cualquier subpaquete dentro del paquete dao
    // y el "*" para indicar cualquier clase dentro de ese paquete o subpaquete

    // y otro "*" para indicar cualquier méthod que empiece por insertClient y que no reciba parámetros
    // @Pointcut("execution(public * com.william.aop.dao..*.insertClient*())")

    // Para todos los métodos públicos de cualquier clase dentro del paquete dao
    //@Pointcut("execution(public * com.william.aop.dao.*.*(..))")

    // Para todos los métodos públicos de cualquier clase dentro del paquete dao (sin subpaquetes)
    @Pointcut("execution(public * com.william.aop.dao.*.*(..))")
    private void forClients(){}

    // Para que actuen sobre getters y setters sobre un paquete concreto
    @Pointcut("execution(public * com.william.aop.dao.*.get*(..))")
    private void forGetters(){}

    //Combinación de pointcuts
    @Pointcut("forClients() && !(forGetters())")
    private void forClientsWhitoutGetters(){}

    // De forma dura -> @Before("execution(public * com.william.aop.dao.ClientVipDAO.insertClient*())")
    // Reutilizable ->

    //@Before("forClients()")
    //@Before("forGetters()")
    @Before("forClientsWhitoutGetters()")
    public void beforeInsert(){
        System.out.println("1 -- Verificando logueo antes de insertar el cliente");

        System.out.println("2 -- Login correcto");

    }

    //@Before("forClients()")

    void requirements(){

        System.out.println("3 -- El cliente cumple los requisitos para la inserción");

    }

    //@Before("forClients()")
    void tableRequeriments(){

        System.out.println("4 -- La tabla todavía no tiene 3mil registros para cumplir los requisitos");

    }
}
 Fin de la primera clase
*/

// 2da clase de aspectos: Ordenamiento de aspectos

@Aspect
@Component
public class LoginClass {

    @Pointcut("execution(public * com.william.aop.dao.*.*(..))")
    public void forClients(){}

}
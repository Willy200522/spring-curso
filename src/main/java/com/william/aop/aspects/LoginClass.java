package com.william.aop.aspects;

import com.william.aop.model.Client;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;


// ======== 1era clase de aspectos ========

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

// ======== 2da clase de aspectos: Ordenamiento de aspectos ========

@Aspect
@Component
public class LoginClass {

    //No puedo ejecutar una tarea después de un method sobre escrito por ejm toString
    //Ya que esos méthods no son reconocidos como beans(components)

    //===========================================================================
    //=========================AFTER RETURNING===============
    // -> Se pasa como parámetro el path del method a inyectar
    // (lleva dos puntas para decir que puede recibir cualquier parámetro) la acción que se hará después
    // -> Como segundo parámetro se pasa el nombre del objeto que utilizaré en mi aspecto
    // es decir copia el objeto que retorna el DAO de cliente (en este caso lo llamamos como el parámetro de este poincut)

    @AfterReturning(pointcut = "execution(* com.william.aop.dao.ClientDAO.searchClient(..))", returning = "clientList")
    public void taskAfterFoundClient(List<Client> clientList){

        System.out.println("(método aspect) " + clientList.get(0).getName() + " -> cliente recuperado");

    }

    //=========================AFTER THROWING===============
    // Dos parámetros,
    // - El poincut(dirección del méthod a ejecutar el at)
    // - Un nombre identificativo, este se lo pasamos al method que ejecuta estas tareas de forma automática

    @AfterThrowing(pointcut = "execution(* com.william.aop.dao.ClientDAO.searchClient(..))", throwing = "myThrow")
    public void executeAfterThrow(Throwable myThrow){

        System.out.println("\"(método aspect) \" .... enviando msg al responsable de solucionar los bugs");

    }

    //=========================AFTER===============
    // Ejecuta una tarea, así no haya excepción
    // Dos parámetros,
    // - El poincut(dirección del méthod a ejecutar el at)
    // - Un nombre identificativo, este se lo pasamos al method que ejecuta estas tareas de forma automática

    @After("execution(* com.william.aop.dao.ClientDAO.searchClient(..))")
    public void executeAfter(JoinPoint myJoin){

        System.out.println("(método aspect) " + myJoin);

        System.out.println("\"(método aspect) \".... always execute it");

    }

    // =============@Around=========
    // Tenemos que usar el Pointcut expression pertinente (el method execution(con su path a donde apunta))
    // Este pointcut que definimos es la forma dura, explicado arriba

//    @Around("execution(* com.william.aop.services.*.getService(..))")
//    public Object executeService(ProceedingJoinPoint myJoin)throws Throwable{
//
//        System.out.println("(méthod aspect) " + myJoin);
//
//        System.out.println("\"(méthod aspect) \".... before execute it");
//
//        Object obj = myJoin.proceed();
//
//        System.out.println("\"(méthod aspect) \".... after execute it");
//
//        return obj;
//    }

    // ejemplo para calcular con el tiempo del sistema
    @Around("execution(public * com.william.aop.services.*.*(..))")
    public Object executeAllServices(ProceedingJoinPoint myJoin)throws Throwable{

        System.out.println("(método aspect) " + myJoin);

        System.out.println("\"(método aspect) \".... before execute it");
        long timestart = System.currentTimeMillis();

        Object obj = myJoin.proceed();

        long timeend = System.currentTimeMillis();


        System.out.println("\"(método aspect) \".... after execute it, time: " + (timeend-timestart)/1000);

        return obj;
    }
}
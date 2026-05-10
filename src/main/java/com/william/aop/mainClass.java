package com.william.aop;

import com.william.aop.dao.ClientDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ClientDAO clientBean = context.getBean(ClientDAO.class);

        boolean myParam= false;

        try {

            System.out.println("(método main) Ejecutando method antes de la execp");

            System.out.println(clientBean.searchClient(myParam));

        } catch (Exception e) {

            System.out.println("Error catched in searchClient");

        }

        System.out.println("(método main) Continuación de la ejecución del programa");

        context.close();

    }
}

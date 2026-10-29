package com.william.connectionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryClient {

    public static void main(String[] args) {

        //Inicializar la session de hibernate
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(com.william.connectionHibernate.Clients.class).
                addAnnotatedClass(com.william.connectionHibernate.OrderClient.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            com.william.connectionHibernate.Clients clients = session.get(Clients.class, 1);

            //session.getTransaction().commit();

            session.close();

            System.out.println("Pedidos: " + clients.getOrder());


        } finally {

            factory.close();
        }
    }
}

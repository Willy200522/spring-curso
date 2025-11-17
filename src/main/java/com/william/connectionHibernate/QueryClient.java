package com.william.connectionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryClient {

    public static void main(String[] args) {

        //Inicializar la session de hibernate
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Clients.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            session.beginTransaction(); // Comenzar la session

            //Consultar los clientes

            List<Clients> clients = session.createQuery("from Clients", Clients.class).getResultList();

            for (Clients clients1: clients) {
                System.out.println(clients1);
            }

            //todos los torvast

            List<Clients> clients2=session.createQuery("from Clients as cl where cl.nombre like '%Torvast'", Clients.class).getResultList();

            System.out.println("Clientes con apellido Torvast");

            for (Clients torvast: clients2) {

                System.out.println(torvast);

            }

            session.getTransaction().commit();

            session.close();

        } finally {
            factory.close();
        }
    }
}

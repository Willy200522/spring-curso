package com.william.connectionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryOrders {

    public static void main(String[] args) {

        //Inicializar la session de hibernate
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Clients.class).
                addAnnotatedClass(OrderClient.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            int id=1;

            session.beginTransaction();

            Clients client = session.get(Clients.class, id);

            System.out.println("Detalle de cliente: " + client.getOrder());

        } finally {

            session.close();

            factory.close();
        }
    }

}

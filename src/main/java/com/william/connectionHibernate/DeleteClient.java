package com.william.connectionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteClient {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(ClientDetail.class).
                addAnnotatedClass(Clients.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {
            //falta agregar recuperación de id
            int id = 5;

            session.beginTransaction();

            //falta agregar validación por si no se encuentra el cliente
            ClientDetail detail = session.get(ClientDetail.class, id);

            System.out.println("detalle de cliente seleccionado: " + detail);

            session.remove(detail);

            session.getTransaction().commit();

            System.out.println("detalle de cliente eliminado: " + detail);

        } finally {

            session.close();

            factory.close();
        }
    }
}

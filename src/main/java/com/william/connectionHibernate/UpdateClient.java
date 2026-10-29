package com.william.connectionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateClient {

    public static void main(String[] args) {

        //Actualización de datos mediante Hibernate

        //Inicializar la session de hibernate
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Clients.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            int idClient = 3;

            session.beginTransaction();

            /*Forma de actualizar datos del ORM mediante POO*/

//            Clients client = session.get(Clients.class, idClient);

//            client.setNombre("Vorkov Linus");

            /*Forma de actualizar mediante HQL*/

            String hqlUpdate = "update Clients as c set c.nombre = :newName where c.idCliente = :id";

            String name = "Segundo Linux";

            int rowAffected = session.createQuery( hqlUpdate )
                    .setParameter("newName", name)
                    .setParameter("id", idClient)
                    .executeUpdate();

            //com.william.connectionHibernate.Clients updatedClient = session.getS;

            session.getTransaction().commit();

            session.close();

        } finally {

            factory.close();

        }

    }
}

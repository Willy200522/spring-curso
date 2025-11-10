package com.william.connectionHibernate;

/*
* Uso de 3 clases de hibernate
* Configuration: para cargar la configuracion de hibernate
* SessionFactory: fabrica de sesiones
* Session: para realizar operaciones CRUD
* */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StoreClient {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Clients.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try{

            Clients client = new Clients("Jhon Doe", "jhon@hotmail.com","9323132");

            session.beginTransaction();

            session.save(client);

            session.getTransaction().commit();

            System.out.println("Cliente guardado con exito: " + client);

        } finally {
            factory.close();
        }

    }
}

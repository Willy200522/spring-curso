package com.william.connectionHibernate;

/*
* Uso de 3 clases de hibernate
* Configuration: para cargar la configuracion de hibernate
* SessionFactory: fabrica de sesiones
* Session: para realizar operaciones CRUD
* */
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StoreClient {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().
                configure().
                addAnnotatedClass(Clients.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try{

            Clients client = new Clients("Bill gates", "pacehco@hotmail.com","9523144");

            session.beginTransaction();

            session.save(client);

            session.getTransaction().commit();

            System.out.println("Cliente guardado con exito: " + client);

            /*
            Lectura de registro

            */

            session.beginTransaction(); // -> iniciamos una nueva transaccion

            System.out.println("Obteniendo cliente con id: " + client.getIdCliente()); // -> id=0, hibernate no sabe que esto es primary key, solo lo reconoce la bd

            Clients insertedClient = session.get(Clients.class, client.getIdCliente());

            System.out.println("Cliente registrado: " + insertedClient.toString());

            session.getTransaction().commit();

            session.close();

        } finally {
            factory.close();

        }

    }
}

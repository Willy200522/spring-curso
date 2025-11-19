package com.william.connectionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StoreClientDetail {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(ClientDetail.class).
                addAnnotatedClass(Clients.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try{

            int id = 8;

            session.beginTransaction();

            Clients client = session.get(Clients.class, id);

            System.out.println("cliente seleccionado: " + client);

            ClientDetail clientDetail = new ClientDetail("Don gato", client);

            session.save(clientDetail);

            //session.remove(client);

            session.getTransaction().commit();

            System.out.println("Detalle guardado con exito: " + clientDetail + "para el cliente: "+ client);

            /*
            Lectura de registro

            */

            /*session.beginTransaction(); // -> iniciamos una nueva transaccion

            System.out.println("Obteniendo cliente con id: " + client.getIdCliente()); // -> id=0, hibernate no sabe que esto es primary key, solo lo reconoce la bd

            Clients insertedClient = session.get(Clients.class, client.getIdCliente());

            System.out.println("Cliente registrado: " + insertedClient.toString());*/

            session.close();

        } finally {
            factory.close();
        }

    }
}

package com.william.connectionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Scanner;

public class StoreOrder {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(OrderClient.class).
                addAnnotatedClass(Clients.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            int idClient = 1;

            session.beginTransaction();

            Clients client = session.get(Clients.class, 1);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter order size: ");
            int orderSize = scanner.nextInt();

            OrderClient order = null;

            for(int i = 0; i < orderSize-1; i++){

                order = new OrderClient(new Date());

                client.addOrders(order);

                session.save(order);

            }

            session.getTransaction().commit();

            System.out.println("Order saved successfully for client: " + client.getNombre());

        } finally {

            session.close();

            factory.close();
        }
    }
}

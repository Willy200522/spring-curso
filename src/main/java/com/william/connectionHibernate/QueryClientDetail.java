package com.william.connectionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryClientDetail {

    public static void main(String[] args) {

        //Inicializar la session de hibernate
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Clients.class).
                addAnnotatedClass(ClientDetail.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            int id=15;

            session.beginTransaction(); // Comenzar la session

            // ===== Consulta del objeto Cliente adjuntandolo a una lista ========

            //List<Clients> clients = session.createQuery("from Clients", Clients.class).getResultList();

            // ===== Consulta de clientes relacionado con ClientDetail almacenandolo en una lista =====

            /* List<ClientDetail> clients = session.createQuery("from ClientDetail as cd inner " +
                            "join cd.client where cd.client.idCliente=:id",
                    ClientDetail.class).setParameter("id",id).getResultList(); */

            // ===== Consultar un objeto por su id ======

            ClientDetail detail = session.get(ClientDetail.class, id);

            System.out.println("Detalle de cliente: " + detail.getClient());

            //System.out.println("cant de filas: " + clients.size());

            /*for (ClientDetail clients1: clients) {
                System.out.println(clients1.getClient().getNombre() + " - " + clients1.getNamePet());
            }*/

/*
            // ===== Consulta de clientes usando una query HQL ======

            List<Clients> clients2=session.createQuery("from Clients as cl where cl.nombre like '%Torvast'", Clients.class).getResultList();

            System.out.println("Clientes con apellido Torvast");

            for (Clients torvast: clients2) {

                System.out.println(torvast);

            }
*/

        } finally {

            // POR SI NO SE LOGRA LLEGAR A LA ULTIMA LINEA DE EJECUCION, LO PONEMOS EN EL FINAL
            // así liberamos recursos y evitamos fugas de memoria

            session.close();

            factory.close();
        }
    }
}


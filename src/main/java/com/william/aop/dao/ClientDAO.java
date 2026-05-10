package com.william.aop.dao;

import com.william.aop.model.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ClientDAO {

    public void insertClient(Client client){

        System.out.println("Insertando cliente en la base de datos");

    }

    public List<Client> searchClient(boolean myParam){

        if (myParam) throw new RuntimeException("Error cannot connect database");

        List<Client> clientLista = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("(método en ClientDao) Ingrese el número de clientes: " );

        int cantClient = sc.nextInt();

        sc.nextLine();

        System.out.println("(método en ClientDao) Ingresando " + cantClient + " clientes: ");

        for (int i = 0; i < cantClient; i++) {

            clientLista.add(new Client(sc.nextLine().trim(),sc.nextLine()));

        }

        System.out.println("(método en ClientDao) ejecución del method buscar finalizada");

        return clientLista;
    }

}
package com.william.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClientDAO {

    public void insertClient(){
        System.out.println("Insertando cliente en la base de datos");
    }

    public String getClientValoration() {

        System.out.println("Obteniendo la valoración del cliente");

        return clientValoration;
    }

    public void setClientValoration(String clientValoration) {

        System.out.println("Estableciendo valoración del cliente");

        this.clientValoration = clientValoration;

    }



    private String clientValoration;

}

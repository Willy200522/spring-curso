package com.william.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClientDAO {

    public void insertClient(){
        System.out.println("Insertando cliente en la base de datos");
    }
}

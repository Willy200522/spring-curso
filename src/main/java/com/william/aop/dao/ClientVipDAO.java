package com.william.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClientVipDAO {

    public void insertClient(int number){
        System.out.println("Insertando cliente VIP en la base de datos");
    }

    public void insertClientVIP(ClientDAO client1) {
        System.out.println("Insercion gaaaaaaaaaaaaaaaa");
    }
}

package com.william.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClientVipDAO {

    public void insertClient(){
        System.out.println("Insertando cliente VIP en la base de datos");
    }
}

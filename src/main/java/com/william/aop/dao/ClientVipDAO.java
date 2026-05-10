package com.william.aop.dao;

import com.william.aop.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientVipDAO {

    public void insertClient(int number){
        System.out.println("Insertando cliente VIP en la base de datos");
    }

    public void insertClientVIP(Client client1) {System.out.println("Cliente insertado: " + client1.getName());}

}

package com.william.aop;

import com.william.aop.dao.ClientDAO;
import com.william.aop.dao.ClientVipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ClientDAO client = context.getBean(ClientDAO.class);

        ClientVipDAO clientVip = context.getBean(ClientVipDAO.class);

        ClientDAO client1 = new ClientDAO();

        client.insertClient(client);

        clientVip.insertClient(5);

        clientVip.insertClientVIP(client1);

        context.close();

    }
}

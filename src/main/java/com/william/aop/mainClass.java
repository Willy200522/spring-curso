package com.william.aop;

import com.william.aop.dao.ClientDAO;
import com.william.aop.dao.ClientVipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ClientDAO client = context.getBean(ClientDAO.class);
        ClientVipDAO clientVip = context.getBean(ClientVipDAO.class);

        clientVip.insertClient();
        client.insertClient();

        context.close();

    }
}

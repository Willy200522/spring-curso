package com.william.testHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/testhibernate";

        String user = "william";

        String password = "1234";

        try {

            String message = "try connected w/ database";

            System.out.println(message + jdbcUrl);

            Connection myConnection = DriverManager.getConnection(jdbcUrl,user,password);

            System.out.println("Conexion exitosa, esquema: " + myConnection.getMetaData());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }
}

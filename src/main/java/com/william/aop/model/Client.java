package com.william.aop.model;

import org.springframework.stereotype.Component;

@Component
public class Client {

    public Client(){}

    public Client(String name, String type) {

        this.name = name;

        this.type = type;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getType() {

        return type;

    }

    public void setType(String type) {

        this.type = type;

    }

    @Override
    public String toString() {
        return "(Clase cliente) Client{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String name;
    private String type;
}

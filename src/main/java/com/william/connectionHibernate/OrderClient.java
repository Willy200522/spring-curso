package com.william.connectionHibernate;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "OrderClient")
public class OrderClient {
    public OrderClient() {}

    public OrderClient(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return "OrderClient{" +
                "idOrder=" + idOrder +
                ", client=" + client +
                ", orderDate=" + orderDate.getTime() +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrder") //Especificar cada columna en la tabla
    private int idOrder;
    @Column(name = "orderDate")
    private Date orderDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "idCliente")
    private Clients client;

}


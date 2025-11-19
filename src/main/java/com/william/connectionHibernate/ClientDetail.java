package com.william.connectionHibernate;

import jakarta.persistence.*;

@Entity //Corresponde con una tabla en nuestra bd
@Table(name = "clientDetail") //Nombre de la tabla en la bd
public class ClientDetail {

    public ClientDetail() {

    }

    public ClientDetail(String namePet, Clients client) {
        this.namePet = namePet;
        this.client = client;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientDetail{" +
                ", client=" + client.getNombre() +
                ", namePet='" + namePet + '\'' +
                '}';
    }

    @Id //Clave primaria
    /*
        Definimos la llave primaria, el tipo(strategy) es para que el ORM
        pueda identificar la llave almacenada en la db.
        (ejm: AUTO, identity, sequenence como en ORACLE o UUID))
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idDetail") //Especificar cada columna en la tabla
    private int idDetail;

    @Column(name = "namePet")
    private String namePet;

    //Mapeamos la relacion ManyToOne
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clients client;
}

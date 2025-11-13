package com.william.connectionHibernate;

import jakarta.persistence.*;

@Entity //Corresponde con una tabla en nuestra bd
@Table(name = "clients") //Nombre de la tabla en la bd
public class Clients {

    public Clients() {

    }

    //Constructor sin id generado automaticamente
    public Clients(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


    @Id //Clave primaria
    /*
        Definimos la llave primaria, el tipo(strategy) es para que el ORM
        pueda identificar la llave almacenada en la db.
        (ejm: AUTO, identity, sequenence como en ORACLE o UUID))
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idCliente") //Especificar cada columna en la tabla
    private int idCliente;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;
}

package com.mycompany.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grupos {

    @Id
    @GeneratedValue
    private int id;
    private String descripcion;

    public Grupos(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Grupos() {
        this.id = 0;
        this.descripcion = "";
    }

    public Grupos(Grupos grupos) {
        this.id = grupos.getId();
        this.descripcion = grupos.getDescripcion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }

}

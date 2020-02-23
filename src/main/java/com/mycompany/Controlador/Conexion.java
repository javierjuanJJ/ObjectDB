package com.mycompany.Controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Conexion {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static final String url = "objectdb:empresa.odb;drop";

    public static EntityManagerFactory getConnectionemf() throws PersistenceException, Exception {
        emf = Persistence.createEntityManagerFactory(url);

        return emf;

    }

    public static EntityManager getConnectionem() throws PersistenceException, Exception {
        em = Persistence.createEntityManagerFactory(url).createEntityManager();

        return em;

    }

    public static void cerrar() throws PersistenceException, Exception {

        em.close();

    }

}

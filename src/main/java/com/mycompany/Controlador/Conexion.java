package com.mycompany.Controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBRuntimeException;

public class Conexion {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static ODB odb;
    private static final String url = "empresa.odb";

    public static EntityManagerFactory getConnectionemf() throws Exception {

       try {
            emf = Persistence.createEntityManagerFactory(url);
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }


        return emf;

    }
    
    public static EntityManager getConnectionem() throws Exception {

       try {
            em = emf.createEntityManager();
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }


        return em;

    }

    public static void cerrar() {

        if (em != null) {
            try {
                em.close();

            } catch (ODBRuntimeException ex) {
                System.err.println("Error " + ex.getMessage());
            } catch (Exception ex) {
                System.err.println("Error " + ex.getMessage());
            }
        }

    }

}

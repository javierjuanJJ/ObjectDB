/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.Controlador.Conexion;
import com.mycompany.Controlador.GenericoDAO;
import com.mycompany.Modelo.Clientes;
import com.mycompany.Modelo.Grupos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author batoi
 */
public class GruposDAO implements GenericoDAO<Grupos> {

    private static EntityManager em;

    public GruposDAO() throws Exception {
        em = Conexion.getConnectionem();
    }

    @Override
    public Grupos findByPK(int id) throws Exception {
        TypedQuery<Grupos> query = em.createQuery("SELECT c FROM Grupos c WHERE c.id= " + id, Grupos.class);
        List<Grupos> Grupos_recibidos = query.getResultList();
        return Grupos_recibidos.get(0);

    }

    @Override
    public List<Grupos> findAll() throws Exception {
        List<Grupos> Grupos_recibidos = new ArrayList();

        TypedQuery<Grupos> query = em.createQuery("SELECT c FROM Grupos c", Grupos.class);
        Grupos_recibidos = query.getResultList();
        return Grupos_recibidos;

    }

    @Override
    public List<Grupos> findBySQL(String sqlselect) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Grupos t) throws Exception {

        boolean resultado = true;
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        return resultado;

    }

    @Override
    public boolean update(Grupos t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grupos> findByExample(Object example) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

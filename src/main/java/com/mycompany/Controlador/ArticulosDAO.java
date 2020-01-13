package com.mycompany.Controlador;

import com.mycompany.Modelo.Articulos;
import com.mycompany.Modelo.Clientes;
import com.mycompany.Modelo.Grupos;
import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;

import javafx.application.Platform;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.core.query.nq.SimpleNativeQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class ArticulosDAO implements GenericoDAO<Articulos> {

    private static final String sql_select_by_PK = "SELECT * FROM empresa_ad.articulos WHERE id=?;";
    private static final String sql_select_by_PK_grupos = "SELECT * FROM empresa_ad.grupos WHERE id=?;";
    private static final String sql_select_all = "SELECT * FROM empresa_ad.articulos;";
    private static final String sql_select_all_grupos = "SELECT * FROM empresa_ad.grupos;";
    private static final String sql_UPDATE = "UPDATE `empresa_ad`.`articulos` SET `nombre`=?, `precio`=?, `codigo`=?, `grupo`=? WHERE `id`=?;";
    private static final String sql_INSERT = "INSERT INTO `empresa_ad`.`articulos` (`nombre`, `precio`, `codigo`, `grupo`) VALUES (?, ?, ?, ?);";
    private static final String sql_DELETE = "DELETE FROM `empresa_ad`.`articulos` WHERE `id`=?;";
    private static final String sql_INSERT_GRUPO = "INSERT INTO `empresa_ad`.`grupos` (`descripcion`) VALUES (?);";
    
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public ArticulosDAO() {
        try {
            emf = Conexion.getConnectionemf();
            em = Conexion.getConnectionem();

        } catch (Exception e) {

            //Platform.exit();
        }
    }

    public Articulos findByPK(int id_articulo) throws Exception {
        TypedQuery<Articulos> query = em.createQuery("SELECT c FROM Articulos c WHERE c.Id= " + id_articulo, Articulos.class);
        List<Articulos> Articulos_recibidos = query.getResultList();
        return Articulos_recibidos.get(0);
    }

    public Grupos findByPK_grupos(int id_grupo) throws Exception {
        TypedQuery<Grupos> query = em.createQuery("SELECT c FROM Grupos c WHERE c.Id= " + id_grupo, Grupos.class);
        List<Grupos> Grupos_recibidos = query.getResultList();
        return Grupos_recibidos.get(0);
    }

    public List<Articulos> findAll() throws Exception {
         TypedQuery<Articulos> query = em.createQuery("SELECT c FROM Articulos c", Articulos.class);
        List<Articulos> Articulos_recibidos = query.getResultList();
        return Articulos_recibidos;
    }

    public List<Grupos> findAll_grupos() throws Exception {
        TypedQuery<Grupos> query = em.createQuery("SELECT c FROM Grupos c", Grupos.class);
        List<Grupos> grupos_recibidos = query.getResultList();
        return grupos_recibidos;
    }

    public List<Articulos> findBySQL(String sqlselect) throws Exception {
        return null;
    }

    public boolean insert(Articulos t) throws Exception {
        boolean resultado = true;
       em.getTransaction().begin();
       em.persist(t);
       em.getTransaction().commit();

        return resultado;
    }


    public boolean update(Articulos t) throws Exception {
       Articulos employee = em.find(Articulos.class, t.getId());
       em.getTransaction().begin();
       employee = new Articulos(t);
       em.getTransaction().commit();

        return true;

    }

    public boolean delete(int id_articulo) throws Exception {
      Articulos employee = em.find(Articulos.class, id_articulo);
em.getTransaction().begin();
em.remove(employee);
em.getTransaction().commit();
        return true;

    }

    public boolean insert(Grupos t) throws Exception {
       boolean resultado = true;
       em.getTransaction().begin();
       em.persist(t);
       em.getTransaction().commit();

        return resultado;
    }

    @Override
    public List<Articulos> findByExample(Object example) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    

}

package com.mycompany.Controlador;

import com.mycompany.Modelo.Articulos;
import com.mycompany.Modelo.Clientes;
import com.mycompany.Modelo.Grupos;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class ClientesDAO implements GenericoDAO<Clientes> {

    protected static final String sql_select_by_PK = "SELECT * FROM empresa_ad.clientes WHERE id=?;";
    protected static final String sql_select_all = "SELECT * FROM empresa_ad.clientes;";
    protected static final String sql_UPDATE = "UPDATE `empresa_ad`.`clientes` SET `nombre`=?, `direccion`=? WHERE `id`=?;";
    protected static final String sql_INSERT = "INSERT INTO `empresa_ad`.`clientes` (`nombre`, `direccion`) VALUES (?, ?);";
    protected static final String sql_DELETE = "DELETE FROM `empresa_ad`.`clientes` WHERE `id`=?;";

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public ClientesDAO() {
        try {
            emf = Conexion.getConnectionemf();
            em = Conexion.getConnectionem();

        } catch (Exception e) {

            Platform.exit();
        }
    }

    public Clientes findByPK(int id) throws Exception {
        TypedQuery<Clientes> query = em.createQuery("SELECT c FROM Clientes c WHERE c.id= " + id, Clientes.class);
        List<Clientes> Clientes_recibidos = query.getResultList();
        return Clientes_recibidos.get(0);
    }

    public List<Clientes> findAll() throws Exception {
        List<Clientes> Clientes_recibidos = new ArrayList();

        try {
            TypedQuery<Clientes> query = em.createQuery("SELECT c FROM Clientes c", Clientes.class);
            Clientes_recibidos = query.getResultList();
        } catch (Exception e) {
            Clientes_recibidos = new ArrayList();
        }

        return Clientes_recibidos;
    }

    public List<Clientes> findBySQL(String sqlselect) throws Exception {
        return null;
    }

    public boolean insert(Clientes t) throws Exception {
        boolean resultado = true;
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        return resultado;
    }

    public boolean update(Clientes t) throws Exception {

        Clientes employee = em.find(Clientes.class, t.getId());
        em.getTransaction().begin();
        employee.setNombre(t.getNombre());
        employee.setDireccion(t.getDireccion());
        employee.setpasswd(t.getpasswd());
        em.getTransaction().commit();

        return true;

    }

    public boolean delete(int id) throws Exception {
        Clientes employee = em.find(Clientes.class, id);
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
        return true;

    }

    @Override
    public List<Clientes> findByExample(Object example) throws Exception {
        List<Clientes> lista_Clientes = new ArrayList();
        Clientes ejemplo = (Clientes) example;

        String Query = "SELECT c FROM Clientes c" + " WHERE c.nombre LIKE '%" + ejemplo.getNombre() + "%' OR c.direccion LIKE '%" + ejemplo.getDireccion() + "%'";

        TypedQuery<Clientes> query = em.createQuery(Query, Clientes.class);
        lista_Clientes = query.getResultList();

        return lista_Clientes;

    }

}

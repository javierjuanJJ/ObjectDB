package dao;

import com.mycompany.Controlador.Conexion;
import com.mycompany.Controlador.GenericoDAO;
import com.mycompany.Modelo.Articulos;
import com.mycompany.Modelo.Clientes;
import com.mycompany.Modelo.Grupos;
import static com.objectdb.o.MSS.cb;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javafx.application.Platform;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class ArticulosDAO implements GenericoDAO<Articulos> {

    private static EntityManager em;

    public ArticulosDAO() throws Exception {
        em = Conexion.getConnectionem();
    }

    public Articulos findByPK(int id_articulo) throws Exception {
        TypedQuery<Articulos> query = em.createQuery("SELECT c FROM Articulos c WHERE c.id= " + id_articulo, Articulos.class);
        List<Articulos> Articulos_recibidos = query.getResultList();
        return Articulos_recibidos.get(0);
    }

    public Grupos findByPK_grupos(int id_grupo) throws Exception {
        TypedQuery<Grupos> query = em.createQuery("SELECT c FROM Grupos c WHERE c.id= " + id_grupo, Grupos.class);
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

    public List<Grupos> findByExampleGrupos(Object example) throws Exception {
        List<Grupos> lista_grupos = new ArrayList();
        Grupos ejemplo = (Grupos) example;

        String Query = "SELECT c FROM Grupos c" + " WHERE c.descripcion LIKE '%" + ejemplo.getDescripcion();

        TypedQuery<Grupos> query = em.createQuery(Query, Grupos.class);
        lista_grupos = query.getResultList();

        return lista_grupos;

    }

    public List<Articulos> findBySQL(String sqlselect) throws Exception {
        return null;
    }

    public boolean insert(Articulos t) throws Exception {
        boolean resultado = true;
        em.getTransaction().begin();
        t.setId(0);
        em.persist(t);
        em.getTransaction().commit();

        return resultado;
    }

    public boolean update(Articulos t) throws Exception {
        Articulos employee = em.find(Articulos.class, t.getId());
        em.getTransaction().begin();
        employee.setNombre(t.getNombre());
        employee.setCodigo(t.getCodigo());
        employee.setGrupo(t.getGrupo());
        employee.setPrecio(t.getPrecio());
        employee.setStock(t.getStock());
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
        List<Articulos> lista_articulos = new ArrayList();
        Articulos ejemplo = (Articulos) example;

        String Query = "SELECT c FROM Articulos c" + " WHERE c.nombre LIKE '%" + ejemplo.getNombre() + "%'" + " OR c.precio = " + ejemplo.getPrecio() + " OR c.grupo = " + ejemplo.getGrupo() + " OR c.codigo LIKE '%" + ejemplo.getCodigo() + "%'" + " OR c.stock = " + ejemplo.getStock();

        TypedQuery<Articulos> query = em.createQuery(Query, Articulos.class);
        lista_articulos = query.getResultList();

        return lista_articulos;

    }

}

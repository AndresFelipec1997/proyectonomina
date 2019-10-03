/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import org.hibernate.Query;
import pojos.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ASUS PC
 */
public class Empleadocontrolador {
    
  
    
    Session session = null;
    Transaction transaction = null;

    public List<Empleado> list() throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Query q = session.createQuery("from Empleado");
            return (List<Empleado>) q.list();
        } catch (Exception e) {
            throw new Exception("Imposible lista los empleados");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Empleado getById(Integer idempleado) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();
        Empleado empleado = null;
        try {
            empleado = (Empleado) session.load(Empleado.class, idempleado);
            int id = empleado.getIdempleado();
            String nombres = empleado.getNombre();
            System.out.print(id);
        } catch (Exception e) {
            throw new Exception("Imposible encontrar el empleado");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return empleado;
    }

    public void create(Empleado empleado) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw new Exception("Imposible crear el empleado");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Integer idEmpleado) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            Empleado empleado = (Empleado) session.load(Empleado.class, idEmpleado);
            session.delete(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Imposible eliminar el empleado");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Empleado empleado) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.update(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Imposible actualizar el empleado");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}

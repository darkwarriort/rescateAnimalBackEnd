/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.repositorios;

import com.rescate.entidades.Raza;
import com.rescate.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DTUMBACO
 */
@Service
public class RepoUsuario {
      public List<Usuario> obtener() {
        Session sesion = null;
        List<Usuario> razas = new ArrayList<Usuario>();
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            String q = "select * from usuario";
            SQLQuery query = sesion.createSQLQuery(q).addEntity(Usuario.class);
            razas = query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return razas;

    }
      public Usuario obtener(String idUsuario) {
        Session sesion = null;
        Usuario user = null;
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            String q = "select * from usuario where idUsuario ="+idUsuario;
            SQLQuery query = sesion.createSQLQuery(q).addEntity(Usuario.class);
            user = (Usuario)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;

    }
      public Usuario crear(Usuario u) {
        Session sesion = null;
        
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
//            String q = "select * from usuario";
//            SQLQuery query = sesion.createSQLQuery(q).addEntity(Usuario.class);
//            razas = query.list();
            sesion.saveOrUpdate(u);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return u;

    }
    

       Session obtenerSesion() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Usuario.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session sesion = sf.openSession();
        return sesion;
    }
}

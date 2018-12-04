/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.repositorios;

import com.rescate.entidades.Reportar;
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
public class RepoReportar {
    
    
    
     public List<Reportar> obtener() {
        Session sesion = null;
        List<Reportar> razas = new ArrayList<Reportar>();
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            String q = "select * from reportar";
            SQLQuery query = sesion.createSQLQuery(q).addEntity(Reportar.class);
            razas = query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return razas;

    }
    
      public Reportar crear(Reportar u) {
        Session sesion = null;
        
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            sesion.saveOrUpdate(u);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return u;

    }
      Session obtenerSesion() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Reportar.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session sesion = sf.openSession();
        return sesion;
    }
}

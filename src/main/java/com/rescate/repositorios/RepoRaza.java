/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.repositorios;

import com.rescate.entidades.Especie;
import com.rescate.entidades.Raza;
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
public class RepoRaza {
    
    
    public List<Raza> obtener() {
        Session sesion = null;
        List<Raza> razas = new ArrayList<Raza>();
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            String q = "select * from raza";
            SQLQuery query = sesion.createSQLQuery(q).addEntity(Raza.class);
            razas = query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return razas;

    }

     public List<Raza> obtenerPorIdEspecie(String especie) {
        Session sesion = null;
        List<Raza> razas = new ArrayList<Raza>();
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            String q = "select * from raza where estado = 'ACTIVO' and idEspecie = "+especie;
            SQLQuery query = sesion.createSQLQuery(q).addEntity(Raza.class);
            razas = query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return razas;

    }
       Session obtenerSesion() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Raza.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session sesion = sf.openSession();
        return sesion;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.repositorios;

import com.rescate.entidades.Especie;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Service;

/**
 *
 * @author DTUMBACO
 */
@Service
public class RepoEspecie {
      String tabla = "especie";

    public List<Especie> obtener() {
        Session sesion = null;
        List<Especie> especies = new ArrayList<Especie>();
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            String q = "select * from especie where estado = 'ACTIVO'";
            SQLQuery query = sesion.createSQLQuery(q).addEntity(Especie.class);
            especies = query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return especies;

    }

    
    Session obtenerSesion() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Especie.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session sesion = sf.openSession();
        return sesion;
    }

}

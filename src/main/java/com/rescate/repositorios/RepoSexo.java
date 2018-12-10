/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.repositorios;

import com.rescate.entidades.Raza;
import com.rescate.entidades.Sexo;
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
public class RepoSexo {
      public List<Sexo> obtener() {
        Session sesion = null;
        List<Sexo> sexos = new ArrayList<Sexo>();
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            String q = "select * from sexo where estado = 'ACTIVO'";
            SQLQuery query = sesion.createSQLQuery(q).addEntity(Sexo.class);
            sexos = query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sexos;

    }
    

       Session obtenerSesion() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Sexo.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session sesion = sf.openSession();
        return sesion;
    }
}

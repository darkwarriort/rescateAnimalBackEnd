/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.repositorios;

import com.rescate.entidades.Participante;
import com.rescate.entidades.Postulante;
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
public class RepoParticipante {
    
    public Participante crear(Participante u) {
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
        Configuration conf = new Configuration().configure().addAnnotatedClass(Participante.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session sesion = sf.openSession();
        return sesion;
    }
}

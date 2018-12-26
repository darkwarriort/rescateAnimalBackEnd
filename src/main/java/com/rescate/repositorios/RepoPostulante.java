/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.repositorios;

import com.rescate.entidades.Postulante;
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
public class RepoPostulante {

    public List<Object> obtenerListaExtendida(String idUsuario) {
        Session sesion = null;
        List<Object> razas = new ArrayList<Object>();
        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            String q = " select a.id, a.nombre, a.descripcion, a.estado_animal,\n"
                    + " a.foto , e.nombre as especie , ra.nombre as raza ,"
                    + " se.nombre as sexo\n"
                    + " from postulantes p\n"
                    + " inner join adopcion a on a.id = p.id_adopcion\n"
                    + " inner join usuario u on u.id_usuario = p.id_usuario\n"
                    + " inner join especie e on a.id_especie = e.id_especie\n"
                    + " inner join raza ra on ra.id_raza = a.id_raza \n"
                    + " inner join sexo se on se.id_sexo = a.id_sexo\n"
                    + " where a.estado = 'ACTIVO' and p.id_usuario = '" + idUsuario + "'";
            SQLQuery query = sesion.createSQLQuery(q);
            query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
            razas = query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return razas;

    }

    public Postulante crear(Postulante u) {
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

    public List<Postulante> crear(List<Postulante> us) {
        Session sesion = null;

        try {
            sesion = obtenerSesion();
            Transaction tx = sesion.beginTransaction();
            for (Postulante u : us) {
                sesion.saveOrUpdate(u);    
            }
            
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return us;

    }

    Session obtenerSesion() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Postulante.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session sesion = sf.openSession();
        return sesion;
    }
}

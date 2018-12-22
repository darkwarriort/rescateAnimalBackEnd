/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DTUMBACO
 */

@Entity
@Table(name = "postulantes")
public class Postulante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_post;    
    private Long id_usuario;    
    private Long id_adopcion;    

    public Postulante() {
    }

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_adopcion() {
        return id_adopcion;
    }

    public void setId_adopcion(Long id_adopcion) {
        this.id_adopcion = id_adopcion;
    }
    
    
    
    
}

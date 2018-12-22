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
@Table(name = "salud")
public class Salud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_salud;
    private String nombre;

    private Long detalle;
    private String estado;

    public Long getId_salud() {
        return id_salud;
    }

    public void setId_salud(Long id_salud) {
        this.id_salud = id_salud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getDetalle() {
        return detalle;
    }

    public void setDetalle(Long detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}

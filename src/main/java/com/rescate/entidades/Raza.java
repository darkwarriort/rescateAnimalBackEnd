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
@Table(name = "raza")
public class Raza {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_raza;
    private String nombre;
    private Long id_especie;
    private String estado;
    private Long id_usuario;

    public Raza() {
    }

    public Long getId_raza() {
        return id_raza;
    }

    public void setId_raza(Long id_raza) {
        this.id_raza = id_raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_especie() {
        return id_especie;
    }

    public void setId_especie(Long id_especie) {
        this.id_especie = id_especie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
        
    
}

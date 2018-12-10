/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DTUMBACO
 */
@Entity
@Table(name = "reportar")

public class Reportar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReporte;
    private String nombre;
    private Long id_especie;
    private Long id_raza;
    private String edad;
    private Long id_sexo;
    private String color;
    private String telefono;
    private String direccion;
    private String coordenadas;
    private float latitud;
    private float longitud;

    private String foto;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd H:mm:ss", timezone = "America/Guayaquil")
    private Date fecha;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd H:mm:ss", timezone = "America/Guayaquil")
    private Date fecha_modificacion;
    private String estado_animal;
    private String estado;

    public Reportar() {
    }

    public Long getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Long idReporte) {
        this.idReporte = idReporte;
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

    public Long getId_raza() {
        return id_raza;
    }

    public void setId_raza(Long id_raza) {
        this.id_raza = id_raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Long getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(Long id_sexo) {
        this.id_sexo = id_sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getEstado_animal() {
        return estado_animal;
    }

    public void setEstado_animal(String estado_animal) {
        this.estado_animal = estado_animal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}

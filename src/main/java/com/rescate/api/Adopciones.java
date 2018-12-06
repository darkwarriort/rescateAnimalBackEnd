/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.api;

import com.rescate.entidades.Adopcion;
import com.rescate.entidades.Especie;
import com.rescate.repositorios.RepoAdopcion;
import com.rescate.repositorios.RepoEspecie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DTUMBACO
 */
@RestController
@CrossOrigin(origins = "*")
public class Adopciones {
        @Autowired
    private RepoAdopcion repositorio_adopcion;

    @GetMapping("/api/adopciones")
    public List<Adopcion> obtenerEspecie() {
        return repositorio_adopcion.obtener();
    }

    
}

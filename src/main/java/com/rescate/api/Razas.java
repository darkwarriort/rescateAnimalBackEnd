/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.api;

import com.rescate.entidades.Especie;
import com.rescate.entidades.Raza;
import com.rescate.repositorios.RepoEspecie;
import com.rescate.repositorios.RepoRaza;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DTUMBACO
 */
@RestController
@CrossOrigin(origins = "*")
public class Razas {
        @Autowired
    private RepoRaza repositorio_razas;

    @GetMapping("/api/raza")
    public List<Raza> obtenerRaza() {
        return repositorio_razas.obtener();
    }
    
      @GetMapping("/api/raza/{idEspecie}")
    public List<Raza> obtenerRazaPorEspecie(@PathVariable ("idEspecie")String idEspecie) {
        return repositorio_razas.obtenerPorIdEspecie(idEspecie);
    }

}

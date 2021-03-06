/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.api;

import com.rescate.repositorios.RepoEvento;
import com.rescate.repositorios.RepoPostulante;
import com.rescate.repositorios.RepoProductos;
import com.rescate.repositorios.RepoSalud;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DTUMBACO
 */
@RestController
@CrossOrigin(origins = "*")
public class Productos {
      @Autowired
    private RepoProductos repositorio_productos;
    
    @GetMapping("/api/productos")
    public List<Object> list() {
        return repositorio_productos.obtener();
    }

}

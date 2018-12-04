/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.api;

import com.rescate.entidades.Reportar;
import com.rescate.entidades.Usuario;
import com.rescate.repositorios.RepoReportar;
import com.rescate.repositorios.RepoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DTUMBACO
 */
@RestController
@CrossOrigin(origins = "*")
public class Reportes {

    @Autowired
    private RepoReportar repositorio_reporte;

    @GetMapping("/api/reportar")
    public List<Reportar> listReportar() {
        return repositorio_reporte.obtener();
    }

    @PostMapping("/api/reportar/new")
    public Reportar crearReporte(@RequestBody Reportar u) {
        return repositorio_reporte.crear(u);
    }
}

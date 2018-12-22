/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.api;

import com.rescate.entidades.Postulante;
import com.rescate.entidades.Reportar;
import com.rescate.entidades.Usuario;
import com.rescate.repositorios.RepoPostulante;
import com.rescate.repositorios.RepoReportar;
import com.rescate.util.SendMail;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DTUMBACO
 */
@RestController
@CrossOrigin(origins = "*")
public class Postulantes {
    

    
    @Autowired
    private RepoPostulante repositorio_postulante;
    
    @GetMapping("/api/postular/{idUsuario}")
    public List<Object> list(@PathVariable("idUsuario") String idUsuario) {
        return repositorio_postulante.obtenerListaExtendida(idUsuario);
    }

    @PostMapping("/api/postular/new")
    public Postulante crear(@RequestBody Postulante u) {
        return repositorio_postulante.crear(u);
    }
    
  
}

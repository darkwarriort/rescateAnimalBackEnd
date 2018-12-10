/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.api;

import com.rescate.entidades.Sexo;
import com.rescate.entidades.Usuario;
import com.rescate.repositorios.RepoSexo;
import com.rescate.repositorios.RepoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DTUMBACO
 */
@RestController
@CrossOrigin(origins = "*")
public class Sexos {
    @Autowired
    private RepoSexo repositorio_sexo;

    @RequestMapping("/api/sexo")
    public List<Sexo> obtenerEspecie() {
        return repositorio_sexo.obtener();
    }
}

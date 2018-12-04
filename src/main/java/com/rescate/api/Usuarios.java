/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rescate.api;

import com.rescate.entidades.Raza;
import com.rescate.entidades.Usuario;
import com.rescate.repositorios.RepoRaza;
import com.rescate.repositorios.RepoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DTUMBACO
 */
@RestController
@CrossOrigin(origins = "*")
public class Usuarios {
        @Autowired
    private RepoUsuario repositorio_usuarios;

//    @RequestMapping("/api/usuario")
//    public Usuario obtenerEspecie() {
//        return ;
//    }

        @PostMapping
        public Usuario crearUsuario(Usuario u ){
           
            return repositorio_usuarios.crear(u);
        }
}

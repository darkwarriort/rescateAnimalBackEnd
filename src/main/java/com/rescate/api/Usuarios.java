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
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/api/usuario")
    public List<Usuario> obtenerEspecie() {
        return repositorio_usuarios.obtener();
    }

    @PostMapping("/api/usuario/valida")
    public Usuario validaUsuario(@RequestBody Usuario u) {
        return repositorio_usuarios.valida(u.getUsuario(), u.getContrasena());
    }

    @PostMapping("/api/usuario/validaCorreo")
    public Usuario validaCorreo(@RequestBody Usuario u) {
        return repositorio_usuarios.validaCorreo(u.getCorreo());
    }

    @PostMapping("/api/usuario/validaUsuario")
    public Usuario validaUserName(@RequestBody Usuario u) {
        return repositorio_usuarios.validaUsuario(u.getUsuario());
    }

    @PostMapping("/api/usuario/new")
    public Usuario crearUsuario(@RequestBody Usuario u) {

        if (repositorio_usuarios.validaUsuario(u.getUsuario()) != null) {
            return new Usuario();
        } else if (repositorio_usuarios.validaCorreo(u.getCorreo()) != null) {
            return new Usuario();
        } else {
            u.setFecha_modificacion(new Date(System.currentTimeMillis()));
            u.setFecha_ingreso(new Date(System.currentTimeMillis()));

            return repositorio_usuarios.crear(u);
        }
    }
}

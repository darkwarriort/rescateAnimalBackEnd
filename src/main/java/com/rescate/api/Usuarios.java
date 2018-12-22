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
import com.rescate.util.SendMail;
import java.security.SecureRandom;
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
    private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @PostMapping("/api/usuario/recovery")
    public Usuario recuperaUsuario(@RequestBody Usuario u) {
        Usuario ua = repositorio_usuarios.validaCorreo(u.getCorreo());

        if (ua != null) {
            try {
                SecureRandom random = new SecureRandom();
                String result = "";
                for (int i = 0; i < 8; i++) {
                    int index = random.nextInt(ALPHA_CAPS.length());
                    result += ALPHA_CAPS.charAt(index);
                }
                ua.setContrasena(MD5(result));
                repositorio_usuarios.crear(ua);

                String content = "Estimad@ " + ua.getNombres() + " su clave de acceso es : " + result;
                String asunto = "Recuperacion de clave";
                new Thread() {
                    @Override
                    public void run() {

                        try {
                            new SendMail().sendmail(ua.getCorreo(), content, asunto);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }.start();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return ua;
        }
        return new Usuario();
    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
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
            repositorio_usuarios.crear(u);
            try {
                if (u.getId_usuario() != null) {
                    String content = "Estimad@ " + u.getNombres() + " gracicas por registrarse en la app Cola";
                    String asunto = "Registro exitoso";
                    new SendMail().sendmail(u.getCorreo(), content, asunto);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return u;
        }
    }
}

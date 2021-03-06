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
public class Reportes {

    private static String UPLOADED_FOLDER = "/var/www/html/image/";

    private static String PUBLIC_IMAGES = "/image/";

    @Autowired
    private RepoReportar repositorio_reporte;
    @Autowired
    private RepoUsuario repositorio_usuario;

    @GetMapping("/api/reportar")
    public List<Object> listReportar() {
        return repositorio_reporte.obtenerListaExtendida();
    }

    @GetMapping("/api/reportar/{idUsuario}")
    public List<Object> listReportarPorUsuario(@PathVariable("idUsuario") String idUsuario) {
        return repositorio_reporte.obtenerListaExtendida(idUsuario);
    }

    @PostMapping("/api/reportar/new")
    public Reportar crearReporte(@RequestBody Reportar u) {
        u.setFecha(new Date(System.currentTimeMillis()));
        u.setFecha_modificacion(new Date(System.currentTimeMillis()));
        try {

            List<Usuario> usuarios = repositorio_usuario.obtener();
            SendMail Mail = new SendMail();

            String content = "Estimad@s se acaba de reportar un animal " + u.getEstado_animal()
                    + " en la direccion: " + u.getDireccion();
            String asunto = "Animal " + u.getEstado_animal();

            for (Usuario usuario : usuarios) {

                new Thread() {
                    @Override
                    public void run() {

                        try {
                            Mail.sendmail(usuario.getCorreo(), content, asunto);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }.start();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return repositorio_reporte.crear(u);
    }

    @PostMapping("/api/reportar/update/{idUsuario}")
    public Reportar actualizarReporte(@PathVariable("idUsuario") String idUsuario, @RequestBody Reportar u) {

        Reportar reporte = repositorio_reporte.obtener(String.valueOf(u.getIdReporte()));
        u.setFecha(reporte.getFecha());

        u.setFecha_modificacion(new Date(System.currentTimeMillis()));

        return repositorio_reporte.update(u);
    }

    @PostMapping("/api/reportar/uploadImage/{idReporte}")
    public Reportar uploadImage(@RequestParam("file") MultipartFile file, @PathVariable("idReporte") String idReporte) {

        Reportar reporte = repositorio_reporte.obtener(idReporte);
        if (!file.isEmpty()) {
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                reporte.setFoto(PUBLIC_IMAGES + file.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        reporte.setFecha_modificacion(new Date(System.currentTimeMillis()));

        return repositorio_reporte.crear(reporte);
    }
}

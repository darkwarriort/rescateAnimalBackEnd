package com.rescate.api;

//import com.rescate.entidades.Empleado;
//import com.serdecom.biometricos.repositorios.Repo_Empleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Empleados {

//    @Autowired
//    private Repo_Empleado repositorio_empleado;
//
//    @RequestMapping("/api/especie/{id}")
//    public List<Empleado> obtenerPorDepartamento(@PathVariable("id") String id) {
//        Long idDepartamento = Long.parseLong(id);
//        return repositorio_empleado.obtenerPorIdDepartamento(idDepartamento);
//
//    }
//    
//     @RequestMapping("/api/empleados/idem/{id}")
//    public List<Empleado> obtenerPorID(@PathVariable("id") String id) {
//        Long idEmpleado = Long.parseLong(id);
//        return repositorio_empleado.obtenerPorId(idEmpleado);
//
//    }
//
//    @RequestMapping("/api/empleados/empresa/{id}")
//    public List<Object> obtenerPorEmpresa(@PathVariable("id") String id) {
//        Long ide = Long.parseLong(id);
//        return repositorio_empleado.obtenerPorIdEmpresa(ide);
//
//    }
//    
//    @RequestMapping(method = RequestMethod.PUT, value = "/api/empleados")
//    public String actualizar(@RequestBody Empleado empleado) {
//         
//        return repositorio_empleado.actualizar(empleado);
//    }
//    
//    
//        @RequestMapping(method = RequestMethod.DELETE, value = "/api/empleados/{id}")
//    public String eliminar(@PathVariable("id") String idEmpresa) {
//
//        return repositorio_empleado.eliminar(idEmpresa);
//    }


}

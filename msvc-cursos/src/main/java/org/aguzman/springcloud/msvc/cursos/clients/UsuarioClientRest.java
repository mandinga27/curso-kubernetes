package org.aguzman.springcloud.msvc.cursos.clients;

import org.aguzman.springcloud.msvc.cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//recibe el nombre del ms y la ruta url
@FeignClient(name = "msvc-usuarios", url = "localhost:8001")
public interface UsuarioClientRest {

    @GetMapping("/{id}")
    //en las interfaces los metodos son publicos por defecto
    public Usuario detalle(@PathVariable(value = "id") Long id);

    @PostMapping("/")
    Usuario crear(@RequestBody Usuario usuario); //devuele un json con el usuario y se transforma en objeto

    @GetMapping("/usuarios-por-curso")
    List<Usuario> obtenerAlumnosPorCurso(@RequestParam("ids") Iterable<Long> ids);

}

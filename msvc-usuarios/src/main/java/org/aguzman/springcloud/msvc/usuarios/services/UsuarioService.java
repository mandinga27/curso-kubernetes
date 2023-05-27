package org.aguzman.springcloud.msvc.usuarios.services;

import org.aguzman.springcloud.msvc.usuarios.models.entity.Usuario;
import org.hibernate.service.spi.OptionallyManageable;

import java.util.List;
import java.util.Optional;


//las clases service se usa para la logica de negocio, dao, objetos repositorios, hace transacciones


public interface UsuarioService {

    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
    List<Usuario> listarPorIds(Iterable<Long> ids); //iterable es "como" un arreglo, parte de la pai de collection de java

    //primer tipo de validacion haciendo consulta con jpa
    Optional<Usuario> porEmail(String email);
}

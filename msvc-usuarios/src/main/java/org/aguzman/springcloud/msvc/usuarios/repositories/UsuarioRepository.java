package org.aguzman.springcloud.msvc.usuarios.repositories;

import org.aguzman.springcloud.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    //primer tipo de validacion haciendo consulta con jpa
    Optional<Usuario> findByEmail(String email);

}

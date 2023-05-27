package org.aguzman.springcloud.msvc.cursos.repositories;

import org.aguzman.springcloud.msvc.cursos.models.entity.Curso;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository  extends CrudRepository<Curso, Long> {

    @Modifying
    @Query("delete from CursoUsuario cu where cu.usuarioId=?1") //=1 cuando el id sea igual al id
    void eliminarCursoUsuarioPorId(Long id); //todo delete no retorna nada -> void
}

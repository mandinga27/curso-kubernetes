package org.aguzman.springcloud.msvc.cursos.entity;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name = "cursos_usuarios")
public class CursoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", unique = true)
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    //para eliminar objetos
    @Override
    public boolean equals(Object obj) { //Object se convierte en cursoUsuario
        if (this == obj) {
            return true;
        }
        //si el obj que se pasa por argumento  -> no es del mismo tipo instance of CursoUsuario devuelve false
        if (!(obj instanceof CursoUsuario)) {
            return false;
        }
        //cast
        CursoUsuario o = (CursoUsuario) obj;
        //se ompara contra el id del usuario
        return this.usuarioId != null && this.usuarioId.equals((o.usuarioId));
    }
}

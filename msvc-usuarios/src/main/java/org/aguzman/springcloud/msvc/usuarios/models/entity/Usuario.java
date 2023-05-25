package org.aguzman.springcloud.msvc.usuarios.models.entity;


import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "usuarios")
public class Usuario {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    //notblank no permite vacio y espacios
    @NotBlank
    private String password;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package org.aguzman.springcloud.msvc.usuarios.models.entity;


import javax.persistence.*;
import javax.websocket.ClientEndpoint;

@Entity
@Table(name = "usuarios")
public class Usuario {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombre;

    @Column(unique = true)
    private String email;

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

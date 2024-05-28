package com.innovaultmy.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "Usuario")
public class UsuarioModel {

    @Getter @Setter
    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @NotNull
    @Column(name = "Nombre", nullable = false, unique = false, length = 50)
    private String nombre;

    @Getter @Setter
    @NotNull
    @Column(name = "apellidoP", nullable = false, unique = false, length = 50)
    private String apellidoP;

    @Getter @Setter
    @NotNull
    @Column(name = "apellidoM", nullable = false, unique = false, length = 50)
    private String apellidoM;

    @Getter @Setter
    @NotNull
    @Column(name = "Contrasenia", nullable = false, length = 255)
    private String contrasenia;


    @Getter @Setter
    @NotNull
    @Column(name = "Codigo_Universitario", nullable = false, unique = true)
    private String codigoUniversitario;

    @Getter @Setter
    @NotNull
    @Column(name = "Permisos", length = 20, nullable = false)
    private String permisos;

    @Getter @Setter
    @NotNull
    @Column(name = "Telefono", nullable = false, length = 20, unique = true)
    private String telefono;

    @Getter @Setter
    @NotNull
    @Column(name = "Correo", length = 255, nullable = false, unique = true)
    private String correo;

    @Setter @Getter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Getter @Setter
    @Lob
    @Column(name = "fotoPerfil", columnDefinition = "bigint")
    private byte[] fotoPerfil;

    public UsuarioModel(Integer id, String nombre, String apellidoP, String apellidoM, String contrasenia, String codigoUniversitario, String permisos, String telefono, String correo, Date fechaRegistro, byte[] fotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.contrasenia = contrasenia;
        this.codigoUniversitario = codigoUniversitario;
        this.permisos = permisos;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.fotoPerfil = fotoPerfil;
    }

    public UsuarioModel(String nombre, String apellidoP, String apellidoM, String contrasenia, String codigoUniversitario, String permisos, String telefono, String correo, Date fechaRegistro, byte[] fotoPerfil) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.contrasenia = contrasenia;
        this.codigoUniversitario = codigoUniversitario;
        this.permisos = permisos;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.fotoPerfil = fotoPerfil;
    }


    public UsuarioModel() {
    }
}
package com.innovaultmy.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "Computadoras")
public class ComputadoraModel
{
    @Setter @Getter
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter @Getter
    @Column(name = "numeroCompu")
    @NotNull
    private Integer numeroDeCompu;

    @Setter @Getter
    @Column(name="modelo")
    private String modelo;

    @Setter @Getter
    @Column(name = "marca")
    private String marca;

    @Setter @Getter
    @Column(name = "notas")
    private String notas;

    @Getter @Setter
    @Column(name="idRegistro")
    private Integer idRegistro;

    @Setter @Getter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Setter @Getter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaEdicion")
    private Date fechaEdicion;

    public ComputadoraModel(Integer id,Integer idRegistro, Integer numeroDeCompu, String modelo, String marca, String notas, Date fechaRegistro, Date fechaEdicion) {
        this.id            = id;
        this.idRegistro    = idRegistro;
        this.numeroDeCompu = numeroDeCompu;
        this.modelo        = modelo;
        this.marca         = marca;
        this.notas         = notas;
        this.fechaRegistro = fechaRegistro;
        this.fechaEdicion  = fechaEdicion;
    }

    public ComputadoraModel(Integer idRegistro, Integer numeroDeCompu, String modelo, String marca, String notas, Date fechaRegistro, Date fechaEdicion) {
        this.idRegistro    = idRegistro;
        this.numeroDeCompu = numeroDeCompu;
        this.modelo        = modelo;
        this.marca         = marca;
        this.notas         = notas;
        this.fechaRegistro = fechaRegistro;
        this.fechaEdicion  = fechaEdicion;
    }

    public ComputadoraModel() {
    }
}

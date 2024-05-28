package com.innovaultmy.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name ="Miscelanea")
public class VariosModel {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVarios")
    private Integer id;

    @Getter @Setter
    @Column(name = "Nombre")
    private String nombre;

    @Getter @Setter
    @Column(name = "Cantidad")
    private int cantidad;

    @Getter @Setter
    @Column(name = "Categoria")
    private String categoria;

    @Getter @Setter
    @Column(name="Descripcion")
    private String descripcion;

    @Getter @Setter
    @Column(name="idRegistro")
    private Integer idRegistro;

    @Getter @Setter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Getter @Setter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaEdicion")
    private Date fechaEdicion;

    public VariosModel(Integer id, Integer idRegistro, String nombre, int cantidad, String categoria,String descripcion, Date fechaRegistro) {
        super();
        this.id = id;
        this.idRegistro = idRegistro;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public VariosModel(Integer idRegistro, String nombre, int cantidad, String categoria,String descripcion, Date fechaRegistro) {
        super();
        this.idRegistro = idRegistro;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public VariosModel() {
        super();
    }
}


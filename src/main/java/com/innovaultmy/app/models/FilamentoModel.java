package com.innovaultmy.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name ="filamento")
public class FilamentoModel  {

    @Setter @Getter
    @Id
    @Column(name = "idFilamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter @Getter
    @Column(name = "Nombre")
    @NotNull
    private String nombre;

    @Setter @Getter
    @NotNull
    @Column(name = "Tipo_de_Filamento")
    private String tipoDeFilamento;

    @Setter @Getter
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;

    @Setter @Getter
    @NotNull
    @Column(name = "Color")
    private String color;

    @Setter @Getter
    @NotNull
    @Column(name = "Notas")
    private String notas;

    @Getter @Setter
    @Column(name="idRegistro")
    private Integer idRegistro;

    @Setter @Getter
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Setter @Getter
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaEdicion")
    private Date fechaEdicion;


    public FilamentoModel(Integer id,Integer idRegistro, String nombre, String tipoDeFilamento, int cantidad, String color, String notas, Date fechaRegistro) {
        super();
        this.id = id;
        this.idRegistro = idRegistro;
        this.nombre = nombre;
        this.tipoDeFilamento = tipoDeFilamento;
        this.cantidad = cantidad;
        this.color = color;
        this.notas = notas;
        this.fechaRegistro = fechaRegistro;
    }

    public FilamentoModel(Integer idRegistro, String nombre, String tipoDeFilamento, int cantidad, String color, String notas, Date fechaRegistro) {
        super();
        this.idRegistro = idRegistro;
        this.nombre = nombre;
        this.tipoDeFilamento = tipoDeFilamento;
        this.cantidad = cantidad;
        this.color = color;
        this.notas = notas;
        this.fechaRegistro = fechaRegistro;
    }

    public FilamentoModel() {
        super();
    }
}
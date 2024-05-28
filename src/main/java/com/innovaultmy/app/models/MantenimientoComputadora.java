package com.innovaultmy.app.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "MantenimientoComputadora")
public class MantenimientoComputadora {
    @Setter @Getter
    @Id
    @Column(name = "idMantComputadora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter @Getter
    @Column(name = "computadora")
    private Integer computadora;

    @Setter @Getter

    @Column(name = "idUsuario")
    private Integer usuario;

    @Setter @Getter
    @Column(name = "nombrePersona")
    private String nombrePersona;

    @Setter @Getter
    @Column(name = "notas")
    private String notas;

    @Setter @Getter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaMantenimiento")
    private Date fechaMantenimiento;

    public MantenimientoComputadora(Integer id, Integer computadora, Integer usuario, String nombrePersona, Date fechaMantenimiento, String notas){
        this.id = id;
        this.computadora = computadora;
        this.usuario = usuario;
        this.nombrePersona = nombrePersona;
        this.fechaMantenimiento = fechaMantenimiento;
        this.notas = notas;
    }
    public MantenimientoComputadora(Integer computadora, Integer usuario, String nombrePersona, Date fechaMantenimiento, String notas){
        this.computadora = computadora;
        this.usuario = usuario;
        this.nombrePersona = nombrePersona;
        this.fechaMantenimiento = fechaMantenimiento;
        this.notas = notas;
    }
    public MantenimientoComputadora() {super();}

}

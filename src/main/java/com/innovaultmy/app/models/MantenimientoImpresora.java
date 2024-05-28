package com.innovaultmy.app.models;

import jakarta.persistence.*;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MantenimientoImpresora")
public class   MantenimientoImpresora {

    @Setter @Getter
    @Id
    @Column(name = "idMantImpresora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Setter @Getter
    @Column(name = "impresora")
    private Integer impresora;

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

    public MantenimientoImpresora(Integer id, Integer impresora, Integer usuario, String nombrePersona, Date fechaMantenimiento, String notas){
        this.id = id;
        this.impresora = impresora;
        this.usuario = usuario;
        this.nombrePersona = nombrePersona;
        this.fechaMantenimiento = fechaMantenimiento;
        this.notas = notas;
    }
    public MantenimientoImpresora(Integer impresora, Integer usuario, String nombrePersona, Date fechaMantenimiento, String notas){
        this.impresora = impresora;
        this.usuario = usuario;
        this.nombrePersona = nombrePersona;
        this.fechaMantenimiento = fechaMantenimiento;
        this.notas = notas;
    }
    public MantenimientoImpresora() {super();}

}

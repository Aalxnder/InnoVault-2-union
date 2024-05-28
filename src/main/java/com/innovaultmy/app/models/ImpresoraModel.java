package com.innovaultmy.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "impresoras")
public class ImpresoraModel
{
    @Setter @Getter
    @Id
    @Column(name = "idImpresora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter @Getter
    @Column(name = "numeroImpresora")
    @NotNull
    private String numImpresora;

    @Setter @Getter
    @NotNull
    @Column(name = "tipoImpresora")
    private String tipo;

    @Setter @Getter
    @NotNull
    @Column(name = "marcaImpresora")
    private String marca;

    @Setter @Getter
    @NotNull
    @Column(name = "estatusImpresora")
    private String estatus;

    @Getter @Setter
    @Column(name="idRegistro")
    private Integer idRegistro;

    @Getter @Setter
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Getter @Setter
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaMantenimiento")
    private Date fechaMantenimiento;



    public ImpresoraModel(Integer id,Integer idRegistro, String numImpresora, String tipo, String marca, String estatus, Date fechaRegistro) {
        super();
        this.id = id;
        this.idRegistro = idRegistro;
        this.numImpresora = numImpresora;
        this.tipo = tipo;
        this.marca = marca;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;

    }

    public ImpresoraModel(Integer idRegistro,String numImpresora, String tipo, String marca, String estatus, Date fechaRegistro) {
        super();
        this.idRegistro = idRegistro;
        this.numImpresora = numImpresora;
        this.tipo = tipo;
        this.marca = marca;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;
    }

    public ImpresoraModel() {
        super();
    }
}

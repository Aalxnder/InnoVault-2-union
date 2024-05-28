package com.innovaultmy.app.models;


import jakarta.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "ObjetosActualizados")
public class ObjetosActualizados {
    @Setter @Getter
    @Id
    @Column(name = "idObjAct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter @Getter
    @Column(name = "idObjeto")
    private Integer idObjeto;

    @Setter @Getter
    @Column(name = "Objeto")
    private String objeto;

    @Setter @Getter
    @Column(name = "Tipo")
    private String tipo;

    @Setter @Getter
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Setter @Getter
    @Column(name = "notas")
    private String notas;

    @Setter @Getter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaActualizacion")
    private Date fechaActualizacion;

    public ObjetosActualizados(Integer id, Integer idObjeto, String objeto, String tipo, Integer idUsuario, String notas){
        this.id                 = id;
        this.idObjeto           = idObjeto;
        this.objeto             = objeto;
        this.tipo               = tipo;
        this.idUsuario          = idUsuario;
        this.notas              = notas;
    }
    public ObjetosActualizados(Integer idObjeto, String objeto,String tipo, Integer idUsuario, String notas){
        this.idObjeto           = idObjeto;
        this.objeto             = objeto;
        this.tipo               = tipo;
        this.idUsuario          = idUsuario;
        this.notas              = notas;
    }
    public ObjetosActualizados() {super();}
}

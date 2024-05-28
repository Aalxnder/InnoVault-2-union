package com.innovaultmy.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "ObjetosEliminados")
public class ObjetosEliminados {
    @Setter @Getter
    @Id
    @Column(name = "idObjElm")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter @Getter
    @Column(name = "idObjeto")
    private Integer idobjeto;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaEliminacion")
    private Date fechaEliminacion;

    public ObjetosEliminados(Integer id, Integer idobjeto, String objeto, String tipo, Integer idusuario){
        this.id = id;
        this.idobjeto = idobjeto;
        this.objeto = objeto;
        this.tipo = tipo;
        this.idUsuario = idusuario;
    }
    public ObjetosEliminados(Integer idobjeto, String objeto,String tipo, Integer idusuario){
        this.idobjeto = idobjeto;
        this.objeto = objeto;
        this.tipo = tipo;
        this.idUsuario = idusuario;
    }
    public ObjetosEliminados() {super();}
}

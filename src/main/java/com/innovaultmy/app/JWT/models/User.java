package com.innovaultmy.app.JWT.models;

//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.*;
//import lombok.Setter;
//import org.antlr.v4.runtime.misc.NotNull;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.util.Date;
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "Usuario")
//public class User
//{
//        @Id
//        @Column(name = "idUsuario")
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        @Column(name = "Nombre", nullable = false, unique = false, length = 50)
//        private String nombre;
//
//        @Column(name = "apellidoP", nullable = false, unique = false, length = 50)
//        private String apellidoP;
//
//        @Column(name = "apellidoM", nullable = false, unique = false, length = 50)
//        private String apellidoM;
//
//        @Column(name = "Contrasenia", nullable = false, length = 255)
//        private String contrasenia;
//
//        @Column(name = "Codigo_Universitario", nullable = false, unique = true)
//        private String codigoUniversitario;
//
////        @Column(name = "Permisos", length = 20, nullable = false)
////        private String permisos;
//
//        @Column(name = "Telefono", nullable = false, length = 20, unique = true)
//        private String telefono;
//
//        @Column(name = "Correo", length = 255, nullable = false, unique = true)
//        private String correo;
//
//        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//        @Column(name = "fechaRegistro")
//        private Date fechaRegistro;
//
//        @Enumerated (EnumType.STRING)
//        Role role;
//
//}

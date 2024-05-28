package com.innovaultmy.app.JWT.models;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository <User, Long>
//{
//    @Query("SELECT u FROM User u WHERE " +
//            "(:nombre IS NULL OR u.nombre = :nombre) AND "+
//            "(:codigoUniversitario IS NULL OR u.codigoUniversitario = :codigoUniversitario) AND " +
//            "(:correo IS NULL OR u.correo = :correo) AND " +
//            "(:role IS NULL OR u.role = :role)")
//    Optional<User> findByAnyField(String nombre, String codigoUniversitario, String correo, Role role);
//    Optional<User> findByCorreo(String Correo);
//}

package com.innovaultmy.app.JWT.config;
//import com.innovaultmy.app.JWT.models.UserRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//@Service
//public class CustomUserDetailsService
//{
//    private final UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
//        // Buscar usuario por correo electrónico
//        User user = userRepository.findByCorreo(correo)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correo));
//
//        // Construir UserDetails basado en el usuario encontrado
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.ge) // Utilizando el correo como nombre de usuario
//                .password(user.getContrasenia())
//                .roles(user.getRole().toString()) // Si tienes un campo en User que represente los roles
//                .build();
//    }
//}

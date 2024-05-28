package com.innovaultmy.app.JWT.Controller;
//
//import com.innovaultmy.app.JWT.jwtImp.JwtService;
//import com.innovaultmy.app.JWT.models.Role;
//import com.innovaultmy.app.JWT.models.User;
//import com.innovaultmy.app.JWT.models.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService
//{
//    private final UserRepository userRepository;
//    private final JwtService jwtService;
//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthResponse login (LoginRequest request)
//    {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getPassword()));
//        UserDetails user = userRepository.findByCorreo(request.getCorreo())
//                .orElseThrow();
//        String token = jwtService.getToken(user);
//        return AuthResponse.builder()
//                .token(token)
//                .build();
//    }
//    public AuthResponse register(RegisterRequest request)
//    {
//        User user = User.builder()
//                .nombre(request.getNombre())
//                .apellidoP(request.getApellidoP())
//                .apellidoM(request.getApellidoM())
//                .contrasenia(request.getContrasenia())
//                .codigoUniversitario(request.getCodigoUniversitario())
//                .permisos(request.getPermisos())
//                .telefono(request.getTelefono())
//                .correo(request.getCorreo())
//                .fechaRegistro(request.getFechaRegistro())
//                .role(Role.Bonilla)
//                .build();
//        userRepository.save(user);
//        return AuthResponse.builder().token(jwtService.getToken(user)).build();
//    }
//}

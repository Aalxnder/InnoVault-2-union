package com.innovaultmy.app.JWT.jwtImp;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.HashMap;
//
//@Service
//public class JwtService
//{
//    private static final String SECRET_KEY = "VXJk7Xrn3mYcb3iQO5xM+bfaKYR+5zH5G7q3HT2DFrQ=";
//    public String getToken(UserDetails user)
//    {
//        return getToken(new HashMap<>(),user);
//    }
//
//    private String getToken(HashMap<String,Object> extraClaims, UserDetails user)
//    {
//        return Jwts.builder()
//                .setClaims(extraClaims)
//                .setSubject(user.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
//                .signWith(getKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//    private Key getKey()
//    {
//        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//}

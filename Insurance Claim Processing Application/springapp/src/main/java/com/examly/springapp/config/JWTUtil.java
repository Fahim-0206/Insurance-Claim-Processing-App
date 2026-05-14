// package com.examly.springapp.config;



// import io.jsonwebtoken.Jwts;

// import io.jsonwebtoken.SignatureAlgorithm;

// import java.util.Date;



// public class JWTUtil {



// private static final String SECRET_KEY = "YourSecretKeyForJWTGeneration"; // Use strong secret in production

// private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds



// public static String generateToken(String subject) {

// return Jwts.builder()

// .setSubject(subject)

// .setIssuedAt(new Date(System.currentTimeMillis()))

// .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))

// .signWith(SignatureAlgorithm.HS256, SECRET_KEY)

// .compact();

// }

// }
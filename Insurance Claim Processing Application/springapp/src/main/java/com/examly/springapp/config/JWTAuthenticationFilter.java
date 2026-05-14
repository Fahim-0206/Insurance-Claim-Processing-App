// package com.examly.springapp.config;

// import io.jsonwebtoken.Jwts;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;
// import java.util.Collections;

// public class JWTAuthenticationFilter extends OncePerRequestFilter {

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//         String header = request.getHeader("Authorization");
//         if (header != null && header.startsWith("Bearer ")) {
//             String token = header.substring(7);
//             try {
//                 // Placeholder: Parse token and validate
//                 String user = Jwts.parser().setSigningKey("your-secret-key").parseClaimsJws(token).getBody().getSubject();
//                 String role = "USER"; // Fetch role from token (e.g., "CUSTOMER", "AGENT", "ADMIN")
//                 SecurityContextHolder.getContext().setAuthentication(
//                     new UsernamePasswordAuthenticationToken(user, null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role)))
//                 );
//             } catch (Exception e) {
//                 SecurityContextHolder.clearContext();
//             }
//         }
//         chain.doFilter(request, response);
//     }
// }
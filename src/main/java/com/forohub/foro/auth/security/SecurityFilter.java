package com.forohub.foro.auth.security;

import com.forohub.foro.auth.service.AuthenticationService;
import com.forohub.foro.auth.service.TokenService;
import com.forohub.foro.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private AuthenticationService service;


    public SecurityFilter(TokenService tokenService, AuthenticationService service) {
        this.tokenService = tokenService;
        this.service = service;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //obtener token
        var authHeader = request.getHeader("Authorization");
        System.out.println(authHeader);
        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var email = tokenService.getSubject(token);
            if (email != null) {
                //token valido
                var usuario = service.loadUserByUsername(email);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities());//FORZAMOS UNICIO DE SESION
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }
        filterChain.doFilter(request, response);
    }
}

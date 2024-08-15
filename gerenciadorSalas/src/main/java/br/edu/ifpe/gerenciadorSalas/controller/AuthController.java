package br.edu.ifpe.gerenciadorSalas.controller;

import br.edu.ifpe.gerenciadorSalas.dto.AuthRequest;
import br.edu.ifpe.gerenciadorSalas.dto.AuthResponse;
import br.edu.ifpe.gerenciadorSalas.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(),
                    authRequest.getPassword()
                )
            );

            // Gerar um token JWT aqui, se aplicável
            String token = "Gerar o token aqui"; // Substitua pela lógica de geração de token

            return ResponseEntity.ok(new AuthResponse("Autenticação bem-sucedida", token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(new AuthResponse("Falha na autenticação"));
        }
    }
}

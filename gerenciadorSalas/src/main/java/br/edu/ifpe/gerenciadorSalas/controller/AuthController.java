package br.edu.ifpe.gerenciadorSalas.controller;

import br.edu.ifpe.gerenciadorSalas.dto.AuthRequest;
import br.edu.ifpe.gerenciadorSalas.dto.AuthResponse;
import br.edu.ifpe.gerenciadorSalas.service.CustomUserDetailsService;
import br.edu.ifpe.gerenciadorSalas.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        try {
            // Authenticate the user without storing the authentication object
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(),
                    authRequest.getPassword()
                )
            );

            // Load the user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());

            // Generate the JWT token
            String token = jwtUtil.generateToken(userDetails);

            // Return the response with the token
            return ResponseEntity.ok(new AuthResponse("Autenticação bem-sucedida", token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(new AuthResponse("Falha na autenticação"));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(500).body("Ocorreu um erro inesperado no servidor.");
        }
    }
}

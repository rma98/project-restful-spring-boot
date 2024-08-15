package br.edu.ifpe.gerenciadorSalas.service;

import br.edu.ifpe.gerenciadorSalas.model.Servidor;
import br.edu.ifpe.gerenciadorSalas.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ServidorRepository servidorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Servidor servidor = servidorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Servidor não encontrado com o email: " + email));

        // Use o BCryptPasswordEncoder para verificar a senha criptografada
        return User.withUsername(servidor.getEmail())
                .password(servidor.getSenha())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))) // Ajuste as roles conforme necessário
                .build();
    }
}

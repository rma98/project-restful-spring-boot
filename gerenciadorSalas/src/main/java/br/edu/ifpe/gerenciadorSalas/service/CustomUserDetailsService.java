package br.edu.ifpe.gerenciadorSalas.service;

import br.edu.ifpe.gerenciadorSalas.model.Servidor;
import br.edu.ifpe.gerenciadorSalas.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ServidorRepository servidorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Servidor servidor = servidorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Servidor não encontrado com o email: " + email));

        return User.withUsername(servidor.getEmail())
                .password(servidor.getSenha())
                .roles("USER") // Pode ser ajustado conforme o perfil do usuário
                .build();
    }
}

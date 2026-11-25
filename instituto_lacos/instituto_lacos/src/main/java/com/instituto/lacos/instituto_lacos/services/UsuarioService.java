package com.instituto.lacos.instituto_lacos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.instituto.lacos.instituto_lacos.configs.JwtService;
import com.instituto.lacos.instituto_lacos.dtos.LoginRequestDTO;
import com.instituto.lacos.instituto_lacos.dtos.LoginResponseDTO;
import com.instituto.lacos.instituto_lacos.models.Usuario;
import com.instituto.lacos.instituto_lacos.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private JwtService jwtService;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO usuario) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha()));
        Usuario usuarioRetornado = usuarioRepository.findByEmail(usuario.getEmail()).orElseThrow();
        String token = jwtService.generateToken(usuarioRetornado.getEmail(),
                usuarioRetornado.getPerfil());
        return new LoginResponseDTO(usuarioRetornado.getEmail(),
                usuarioRetornado.getNomeUsuario(), usuarioRetornado.getPerfil(), token);
    }

    public Usuario buscar(Integer usuarioId){
        return usuarioRepository.findById(usuarioId).get();
    }

}

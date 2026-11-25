package com.instituto.lacos.instituto_lacos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.lacos.instituto_lacos.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}

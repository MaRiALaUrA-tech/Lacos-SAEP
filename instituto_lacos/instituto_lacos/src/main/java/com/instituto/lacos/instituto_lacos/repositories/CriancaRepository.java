package com.instituto.lacos.instituto_lacos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.lacos.instituto_lacos.models.Crianca;

public interface CriancaRepository extends JpaRepository<Crianca, Integer> {
    
}

package com.instituto.lacos.instituto_lacos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instituto.lacos.instituto_lacos.models.Pretendente;

public interface PretendenteRepository extends JpaRepository<Pretendente, Integer> {
    @Query(value="select * from pretendente where nome_pretendente like '%'||:termo||'%';", nativeQuery=true) 
    public List<Pretendente> listarPretendentes(String termo);
}

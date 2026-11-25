package com.instituto.lacos.instituto_lacos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.lacos.instituto_lacos.models.Crianca;
import com.instituto.lacos.instituto_lacos.repositories.CriancaRepository;

@Service 
public class CriancaService {
    @Autowired private CriancaRepository criancaRepository;
    @Autowired private  PretendenteService pretendenteService;

    public Crianca cadastrar(Crianca crianca) {
    crianca.setPretendente(pretendenteService.buscar(crianca.getPretendente().getPretendenteId()));
    return criancaRepository.save(crianca);
}

    public Crianca buscar(Integer criancaId){
        return criancaRepository.findById(criancaId).get();
    }
    
}

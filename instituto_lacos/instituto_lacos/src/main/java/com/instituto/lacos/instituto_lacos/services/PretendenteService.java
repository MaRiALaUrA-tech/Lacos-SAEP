package com.instituto.lacos.instituto_lacos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.instituto.lacos.instituto_lacos.models.Pretendente;
import com.instituto.lacos.instituto_lacos.repositories.PretendenteRepository;

@Service 
public class PretendenteService {
    @Autowired private PretendenteRepository pretendenteRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public List<Pretendente> listarPretendentes(String termo){
        return pretendenteRepository.listarPretendentes(termo);
    }
    public Pretendente buscar(Integer pretendenteId){
        return pretendenteRepository.findById(pretendenteId).get();
    }
    public Pretendente salvar(Pretendente pretendente){
        pretendente.setCpf(passwordEncoder.encode(pretendente.getCpf()));
        return pretendenteRepository.save(pretendente);
    }
    public Pretendente atualizar(Pretendente pretendente, Integer pretendenteId){
        Pretendente pretendenteExistente = buscar(pretendenteId);
        if (pretendenteExistente == null) throw new RuntimeException("Pretendente não encontrado");
        if (pretendente.getCpf() != null)
pretendenteExistente.setCpf(passwordEncoder.encode(pretendente.getCpf()));
        if (pretendente.getNomePretendente() != null)
pretendenteExistente.setNomePretendente(pretendente.getNomePretendente());
        return pretendenteRepository.save(pretendenteExistente);
    }
    public void deletar(Integer pretendenteId) { 
        pretendenteRepository.deleteById(pretendenteId);
    }


}

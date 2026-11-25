package com.instituto.lacos.instituto_lacos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.lacos.instituto_lacos.dtos.AgendamentoResponseDTO;
import com.instituto.lacos.instituto_lacos.models.Agendamento;
import com.instituto.lacos.instituto_lacos.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
    @Autowired private AgendamentoRepository agendamentoRepository;
    @Autowired private CriancaService criancaService;
    @Autowired private UsuarioService usuarioService;

    public List<AgendamentoResponseDTO> listarAgendamentos() {
        return agendamentoRepository.listarAgendamentos().stream()
                .map(Agendamento -> new AgendamentoResponseDTO(Agendamento.getData(), Agendamento.getCrianca()))
                .toList();
    }

    public AgendamentoResponseDTO buscar(Integer agendamentoId) {
        Agendamento agendamento = agendamentoRepository.findById(agendamentoId).get();
        return new AgendamentoResponseDTO(agendamento.getData(),
                agendamento.getCrianca());
    }

    public Agendamento atualizar(Agendamento agendamento, Integer agendamentoId) {  
        Agendamento agendamentoExistente = agendamentoRepository.findById(agendamentoId).get();  
        if (agendamentoExistente == null) {
            throw new RuntimeException("Agendamento não encontrado");
        }  
        if (agendamento.getData() != null) {  
            agendamentoExistente.setData(agendamento.getData());
        }      
        if (agendamento.getCrianca() != null)  { 
            agendamentoExistente.setCrianca(criancaService.buscar(agendamento.getCrianca().getCriancaId()));
        }      
        if (agendamento.getUsuario() != null) {  
            agendamentoExistente.setUsuario(usuarioService.buscar(agendamento.getUsuario().getUsuarioId()));
        }      
        return agendamentoRepository.save(agendamentoExistente);  
    }
}

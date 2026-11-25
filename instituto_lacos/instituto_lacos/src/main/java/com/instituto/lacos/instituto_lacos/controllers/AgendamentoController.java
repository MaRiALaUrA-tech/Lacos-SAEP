package com.instituto.lacos.instituto_lacos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instituto.lacos.instituto_lacos.dtos.AgendamentoResponseDTO;
import com.instituto.lacos.instituto_lacos.models.Agendamento;
import com.instituto.lacos.instituto_lacos.services.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    @Autowired private AgendamentoService agendamentoService;

    @GetMapping("/listar")
    public List<AgendamentoResponseDTO> listarAgendamentos() {
        return agendamentoService.listarAgendamentos();
    }

    @GetMapping("/buscar/{agendamentoId}")
    public AgendamentoResponseDTO buscarAgendamento(@PathVariable Integer agendamentoId) {
        return agendamentoService.buscar(agendamentoId);
    }

    @PutMapping("/atualizar/{agendamentoId}")
    public String atualizarAgendamento(@RequestBody Agendamento agendamento, @PathVariable Integer agendamentoId) {
        agendamentoService.atualizar(agendamento, agendamentoId);
        return "Agendamento atualizado com sucesso";
    }

}

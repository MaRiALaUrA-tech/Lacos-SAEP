package com.instituto.lacos.instituto_lacos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instituto.lacos.instituto_lacos.models.Pretendente;
import com.instituto.lacos.instituto_lacos.services.PretendenteService;

@RestController
@RequestMapping("/pretendente")
public class PretendenteController {
    @Autowired private PretendenteService pretendenteService;

    @GetMapping("/listar")
    public List<Pretendente> listarPretendentes(@RequestParam(required = true) String termo) {
        return pretendenteService.listarPretendentes(termo);
    }

    @GetMapping("/buscar/{pretendenteId}")
    public Pretendente buscar(@PathVariable Integer pretendenteId) {
        return pretendenteService.buscar(pretendenteId);
    }

    @PostMapping("/salvar")
    public Pretendente salvar(@RequestBody Pretendente pretendente) {
        return pretendenteService.salvar(pretendente);

        //SELECT setval(pg_get_serial_sequence('pretendente', 'pretendente_id'), COALESCE((SELECT MAX(pretendente_id) FROM pretendente), 0) + 1, false);
    }

    @PutMapping("/atualizar/{pretendenteId}")
    public Pretendente atualizar(@RequestBody Pretendente pretendente, @PathVariable Integer pretendenteId) {
        return pretendenteService.atualizar(pretendente, pretendenteId);
    }

    @DeleteMapping("/deletar/{pretendenteId}") //é assim mesmo?
    public String deletar(@PathVariable Integer pretendenteId) {
        pretendenteService.deletar(pretendenteId);
        return "Responsável deletado com sucesso";
    }
}

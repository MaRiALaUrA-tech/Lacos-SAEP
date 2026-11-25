package com.instituto.lacos.instituto_lacos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instituto.lacos.instituto_lacos.models.Crianca;
import com.instituto.lacos.instituto_lacos.services.CriancaService;


@RestController 
@RequestMapping("/crianca")
public class CriancaController {
    @Autowired private CriancaService criancaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Crianca> cadastrarCrianca(@RequestBody Crianca crianca) {
        Crianca criancaCadastrada = criancaService.cadastrar(crianca);
        return ResponseEntity.status(HttpStatus.CREATED).body(criancaCadastrada);
    }
    
    
}

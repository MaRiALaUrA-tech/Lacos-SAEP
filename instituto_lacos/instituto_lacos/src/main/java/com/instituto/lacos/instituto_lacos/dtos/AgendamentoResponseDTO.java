package com.instituto.lacos.instituto_lacos.dtos;

import java.time.LocalDate;

import com.instituto.lacos.instituto_lacos.models.Crianca;

public class AgendamentoResponseDTO {
    private LocalDate data;  
    private Crianca crianca;  

    public AgendamentoResponseDTO() {}  

    public AgendamentoResponseDTO(LocalDate data, Crianca crianca) {  
    this.data = data;  
    this.crianca = crianca; 
}
    public LocalDate getData() { return data; }  
    public void setData(LocalDate data) { this.data = data; }  
    public Crianca getCrianca() { return crianca; }  
    public void setCrianca(Crianca crianca) { this.crianca = crianca; }
}

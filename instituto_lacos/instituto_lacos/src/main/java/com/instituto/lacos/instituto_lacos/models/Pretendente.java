package com.instituto.lacos.instituto_lacos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="pretendente")
public class Pretendente{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pretendente_id")
    private Integer pretendenteId;

    @Column(name="nome_pretendente")
    private String nomePretendente;

    @Column(name="cpf")
    private String cpf;

    public Pretendente(){}

    public Pretendente(String cpf, String nomePretendente, Integer pretendenteId) {
        this.cpf = cpf;
        this.nomePretendente = nomePretendente;
        this.pretendenteId = pretendenteId;
    }

    public Integer getPretendenteId() {
        return pretendenteId;
    }

    public void setPretendenteId(Integer pretendenteId) {
        this.pretendenteId = pretendenteId;
    }

    public String getNomePretendente() {
        return nomePretendente;
    }

    public void setNomePretendente(String nomePretendente) {
        this.nomePretendente = nomePretendente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
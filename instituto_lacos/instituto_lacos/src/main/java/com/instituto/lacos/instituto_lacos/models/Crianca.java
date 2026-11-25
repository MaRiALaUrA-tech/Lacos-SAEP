package com.instituto.lacos.instituto_lacos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="crianca")
public class Crianca{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="crianca_id")
    private Integer criancaId;

    @ManyToOne 
    @JoinColumn(name="pretendente_id")
    private Pretendente pretendente;

    public Crianca(){}

    public Crianca(Integer criancaId, Pretendente pretendente) {
        this.criancaId = criancaId;
        this.pretendente = pretendente;
    }

    public Integer getCriancaId() {
        return criancaId;
    }

    public void setCriancaId(Integer criancaId) {
        this.criancaId = criancaId;
    }

    public Pretendente getPretendente() {
        return pretendente;
    }

    public void setPretendente(Pretendente pretendente) {
        this.pretendente = pretendente;
    }


}
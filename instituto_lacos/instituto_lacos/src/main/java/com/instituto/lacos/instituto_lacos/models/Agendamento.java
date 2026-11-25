package com.instituto.lacos.instituto_lacos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="agendamento")
public class Agendamento{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="agendamento_id")
    private Integer agendamentoId;

    @Column(name="data")
    private LocalDate data;

    @ManyToOne 
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne 
    @JoinColumn(name="crianca_id")
    private Crianca crianca;

    public Agendamento(){}

    public Agendamento(Integer agendamentoId, Crianca crianca, LocalDate data, Usuario usuario) {
        this.agendamentoId = agendamentoId;
        this.crianca = crianca;
        this.data = data;
        this.usuario = usuario;
    }

    public Integer getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Integer agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }




}
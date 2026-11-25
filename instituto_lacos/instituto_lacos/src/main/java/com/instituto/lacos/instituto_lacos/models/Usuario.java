package com.instituto.lacos.instituto_lacos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private Integer usuarioId;

    @Column(name="nome_usuario")
    private String nomeUsuario;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

    @Column(name="perfil")  
    private String perfil;  

    public Usuario(){}

    public Usuario(String email, String nomeUsuario, Integer usuarioId, String senha, String perfil) {
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.usuarioId = usuarioId;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    



}
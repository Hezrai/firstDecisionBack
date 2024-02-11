package com.hezrai.spring.jpa.postgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "published")//ta aqui so pra ocupar espaço
    private boolean published;

    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;


    public Usuario() {

    }

    public Usuario(String nome, String cargo, String email, String senha, boolean published) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", cargo=" + cargo + ", published=" + published + ", email=" + email +", senha=" + senha + "]";
    }

}

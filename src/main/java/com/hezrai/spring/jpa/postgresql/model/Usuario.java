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

	@Column(name = "published")
	private boolean published;

	public Usuario() {

	}

	public Usuario(String nome, String cargo, boolean published) {
		this.nome = nome;
		this.cargo = cargo;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String description) {
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
		return "Usuario [id=" + id + ", nome=" + nome + ", carg=" + cargo + ", published=" + published + "]";
	}

}

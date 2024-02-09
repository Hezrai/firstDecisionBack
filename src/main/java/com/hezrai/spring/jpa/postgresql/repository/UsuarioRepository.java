package com.hezrai.spring.jpa.postgresql.repository;

import java.util.List;

import com.hezrai.spring.jpa.postgresql.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hezrai.spring.jpa.postgresql.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  List<Usuario> findByPublished(boolean published);

  List<Usuario> findByNomeContaining(String nome);
}

package com.hezrai.spring.jpa.postgresql.repository;

import com.hezrai.spring.jpa.postgresql.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  List<Usuario> findByPublished(boolean published);

  List<Usuario> findByNomeContaining(String nome);
}

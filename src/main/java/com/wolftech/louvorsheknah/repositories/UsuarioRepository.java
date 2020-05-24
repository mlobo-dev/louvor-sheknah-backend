package com.wolftech.louvorsheknah.repositories;

import com.wolftech.louvorsheknah.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u.id, u.cpf, u.email, u.nome from Usuario u where u.cpf = :cpf")
    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByEmailOrLogin(String email, String login);
}
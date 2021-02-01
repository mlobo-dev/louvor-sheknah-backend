package com.dev4abyss.louvorsheknah.repositories;

import com.dev4abyss.louvorsheknah.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByEmailOrLogin(String email, String login);

    Optional<Usuario>  findByEmail(String emailUsuario);
}
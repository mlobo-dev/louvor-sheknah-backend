package com.wolftech.louvorsheknah.repositories;

import com.wolftech.louvorsheknah.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByEmailOrLogin(String email, String login);

    Optional<Usuario>  findByEmail(String emailUsuario);
}
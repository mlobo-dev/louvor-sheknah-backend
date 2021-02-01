package com.dev4abyss.louvorsheknah.repositories;

import com.dev4abyss.louvorsheknah.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findAllByNomeContainsIgnoreCase(String nome);

    Musica findByNome(String nome);
}


package com.wolftech.louvorsheknah.repositories;

import com.wolftech.louvorsheknah.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findAllByNomeContainsIgnoreCase(String nome);

    Musica findByNome(String nome);
}


package com.dev4abyss.louvorsheknah.repositories;

import com.dev4abyss.louvorsheknah.entity.Musica;
import com.dev4abyss.louvorsheknah.entity.Repertorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepertorioRepository extends JpaRepository<Repertorio, Long> {

    List<Repertorio> findAllByMusicasContains(Musica musica);
}
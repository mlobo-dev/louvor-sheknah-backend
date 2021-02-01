package com.dev4abyss.louvorsheknah.services;

import com.dev4abyss.louvorsheknah.dto.LogDTO;
import com.dev4abyss.louvorsheknah.entity.Log;
import com.dev4abyss.louvorsheknah.exception.ObjectNotFoundException;
import com.dev4abyss.louvorsheknah.mapper.LogMapper;
import com.dev4abyss.louvorsheknah.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository repository;

    @Autowired
    private LogMapper mapper;

    public Log salvar(Log log) {
        return repository.save(log);
    }

    public List<Log> listarTudo() {
        return repository.findAll();
    }

    public Log editarLog(LogDTO dto) {
        buscarPorId(dto.getId());
        return repository.save(mapper.toEntity(dto));
    }

    public Log buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuário não localizado pelo id: " + id)
        );
    }

    public void deletarLog(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

}

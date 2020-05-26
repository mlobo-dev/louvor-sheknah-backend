package com.wolftech.louvorsheknah.services;

import com.wolftech.louvorsheknah.dto.LogDTO;
import com.wolftech.louvorsheknah.entity.Log;
import com.wolftech.louvorsheknah.exception.ObjectNotFoundException;
import com.wolftech.louvorsheknah.mapper.LogMapper;
import com.wolftech.louvorsheknah.repositories.LogRepository;
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

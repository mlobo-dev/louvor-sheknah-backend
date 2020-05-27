package com.wolftech.louvorsheknah.controller;

import com.wolftech.louvorsheknah.dto.LogDTO;
import com.wolftech.louvorsheknah.entity.Log;
import com.wolftech.louvorsheknah.mapper.LogMapper;
import com.wolftech.louvorsheknah.services.LogService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/logs")
@Api(description = "Rotas para operações com Logs", tags = "Logs")
public class LogController {


    private final LogService service;
    private final LogMapper mapper;

    @GetMapping
    public ResponseEntity<List<LogDTO>> listarTudo() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPorId(id)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        service.deletarLog(id);
        return ResponseEntity.noContent().build();
    }


}

package com.wolftech.louvorsheknah.controller;

import com.wolftech.louvorsheknah.dto.MusicaCadastroDTO;
import com.wolftech.louvorsheknah.dto.MusicaDTO;
import com.wolftech.louvorsheknah.mapper.MusicaMapper;
import com.wolftech.louvorsheknah.services.MusicaService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/musicas")
@Api(description = "Rotas para operações com Musicas", tags = "Musicas")
public class MusicaController {


    private final MusicaService service;
    private final MusicaMapper mapper;

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> listarTudo() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/buscar/{texto}")
    public ResponseEntity<List<MusicaDTO>> listarTudo(@PathVariable("texto") String nome) {
        return ResponseEntity.ok(mapper.toDto(service.buscarTodasPeloNome(nome)));
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<MusicaDTO> buscarPeloNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPeloNome(nome)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<MusicaDTO> salvar(@RequestBody MusicaCadastroDTO dto) {
        return new ResponseEntity(mapper.toDto(service.salvar(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MusicaDTO> editar(MusicaDTO dto) {
        return new ResponseEntity(mapper.toDto(service.editarItem(dto)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        service.deletarItem(id);
        return ResponseEntity.noContent().build();
    }


}

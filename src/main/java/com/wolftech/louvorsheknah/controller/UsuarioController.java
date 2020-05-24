package com.wolftech.louvorsheknah.controller;

import com.wolftech.louvorsheknah.dto.UsuarioAuthDTO;
import com.wolftech.louvorsheknah.dto.UsuarioDTO;
import com.wolftech.louvorsheknah.mapper.UsuarioMapper;
import com.wolftech.louvorsheknah.services.UsuarioService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
@Api(tags = "Usuários", description = "Rotas para operações com Usuários")
public class UsuarioController {


    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTudo() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO dto) {
        return new ResponseEntity(mapper.toDto(service.salvar(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editar(UsuarioDTO dto) {
        return new ResponseEntity(mapper.toDto(service.editarUsuario(dto)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        service.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/autenticar")
    public ResponseEntity<UsuarioDTO> autenticar(@RequestBody UsuarioAuthDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.autenticar(dto.getEmailOuLogin(), dto.getSenha())));
    }


}

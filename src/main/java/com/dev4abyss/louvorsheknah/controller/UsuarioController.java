package com.dev4abyss.louvorsheknah.controller;

import com.dev4abyss.louvorsheknah.dto.UsuarioAuthDTO;
import com.dev4abyss.louvorsheknah.dto.UsuarioDTO;
import com.dev4abyss.louvorsheknah.entity.Usuario;
import com.dev4abyss.louvorsheknah.exception.AuthException;
import com.dev4abyss.louvorsheknah.mapper.UsuarioMapper;
import com.dev4abyss.louvorsheknah.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("Lista todos os Usuários ")
    public ResponseEntity<List<UsuarioDTO>> listarTudo() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca o usuário pelo id")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPorId(id)));
    }

    @PostMapping
    @ApiOperation("Salva um novo usuário ")
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO dto) {
        return new ResponseEntity(mapper.toDto(service.salvar(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Edita o usuário")
    public ResponseEntity<UsuarioDTO> editar(UsuarioDTO dto) {
        return new ResponseEntity(mapper.toDto(service.editarUsuario(dto)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta  o usuário pelo id")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        service.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/autenticar")
    @ApiOperation("Rota para autenticar o usuário através do login/email e senha.")
    public ResponseEntity autenticar(@RequestBody UsuarioAuthDTO dto) {
        try {
            Usuario usuarioAutenticado = service.autenticar(dto.getEmailOuLogin(), dto.getSenha());
            return ResponseEntity.ok(mapper.toDto(usuarioAutenticado));
        } catch (AuthException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }


}

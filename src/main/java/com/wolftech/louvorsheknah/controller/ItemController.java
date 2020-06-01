package com.wolftech.louvorsheknah.controller;

import com.wolftech.louvorsheknah.dto.ItemCadastroDTO;
import com.wolftech.louvorsheknah.dto.ItemDTO;
import com.wolftech.louvorsheknah.mapper.ItemMapper;
import com.wolftech.louvorsheknah.services.ItemService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
@Api(description = "Rotas para operações com items", tags = "Items")
public class ItemController {


    private final ItemService service;
    private final ItemMapper mapper;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> listarTudo() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/buscar/{texto}")
    public ResponseEntity<List<ItemDTO>> listarTudo(@PathVariable("texto") String nome) {
        return ResponseEntity.ok(mapper.toDto(service.buscarTodasPeloNome(nome)));
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<ItemDTO> buscarPeloNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPeloNome(nome)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<ItemDTO> salvar(@RequestBody ItemCadastroDTO dto) {
        return new ResponseEntity(mapper.toDto(service.salvar(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ItemDTO> editar(ItemDTO dto) {
        return new ResponseEntity(mapper.toDto(service.editarItem(dto)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        service.deletarItem(id);
        return ResponseEntity.noContent().build();
    }


}

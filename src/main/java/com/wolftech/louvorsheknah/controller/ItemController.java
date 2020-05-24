package com.wolftech.louvorsheknah.controller;

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
@RequestMapping("/itens")
@Api(description = "Rotas para operações com Itens", tags = "Items")
public class ItemController {


    private final ItemService service;
    private final ItemMapper mapper;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> listarTudo() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<ItemDTO> salvar(@RequestBody ItemDTO dto) {
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

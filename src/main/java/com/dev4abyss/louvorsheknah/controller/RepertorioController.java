package com.dev4abyss.louvorsheknah.controller;

import com.dev4abyss.louvorsheknah.dto.MusicaDTO;
import com.dev4abyss.louvorsheknah.dto.RepertorioCadastroDTO;
import com.dev4abyss.louvorsheknah.dto.RepertorioDTO;
import com.dev4abyss.louvorsheknah.entity.Repertorio;
import com.dev4abyss.louvorsheknah.mapper.MusicaMapper;
import com.dev4abyss.louvorsheknah.mapper.RepertorioMapper;
import com.dev4abyss.louvorsheknah.services.RepertorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/repertorios")
@Api(value = "Repertorios", description = "Operaçôes sobre Repertorios", tags = "Repertorios")
@RequiredArgsConstructor
public class RepertorioController {


    private final RepertorioService departamentoService;
    private final RepertorioMapper departamentoMapper;
    private final MusicaMapper musicaMapper;


    @PostMapping
    @ApiOperation("Salva um novo Repertorio")
    public ResponseEntity<RepertorioDTO> save(@Validated @RequestBody final RepertorioCadastroDTO dto) {
        return ResponseEntity.ok(departamentoMapper.toDto(departamentoService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os Repertorios")
    public ResponseEntity<List<RepertorioDTO>> list() {
        List<Repertorio> list = departamentoService.listarTudo();
        return ResponseEntity.ok(departamentoMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um departamento pelo id")
    public ResponseEntity<RepertorioDTO> buscarPeloId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departamentoMapper.toDto(departamentoService.buscarPeloId(id)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um departamento pelo id.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) {
        departamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @ApiOperation("Editar departamentos")
    public ResponseEntity<RepertorioDTO> editar(@Validated @RequestBody final RepertorioDTO departamentoDTO) {
        return ResponseEntity.ok(departamentoMapper.toDto(departamentoService.editar(departamentoDTO)));
    }

    @PostMapping("/{idRepertorio}/add-itens")
    @ApiOperation("Adiciona funcionários através do id do departamento, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<RepertorioDTO> adicionarFuncionarios(@PathVariable("idRepertorio") Long idRepertorio, @RequestBody Set<MusicaDTO> itens) {
        return ResponseEntity.ok(
                departamentoMapper.toDto(departamentoService.adicionarItems(idRepertorio, musicaMapper.toEntity(itens)
                )));
    }

    @PostMapping("/{idRepertorio}/remover-funcionarios")
    @ApiOperation("Remove funcionários através do id do departamento, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<RepertorioDTO> removerFuncionarios(@PathVariable("idRepertorio") Long idRepertorio, @RequestBody Set<MusicaDTO> itens) {
        return ResponseEntity.ok(
                departamentoMapper.toDto(departamentoService.removerItems(idRepertorio, musicaMapper.toEntity(itens)))
        );
    }


}
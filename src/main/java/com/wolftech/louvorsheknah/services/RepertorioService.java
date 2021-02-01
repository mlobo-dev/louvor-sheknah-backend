package com.wolftech.louvorsheknah.services;

import com.wolftech.louvorsheknah.dto.RepertorioCadastroDTO;
import com.wolftech.louvorsheknah.dto.RepertorioDTO;
import com.wolftech.louvorsheknah.entity.Log;
import com.wolftech.louvorsheknah.entity.Musica;
import com.wolftech.louvorsheknah.entity.Repertorio;
import com.wolftech.louvorsheknah.entity.Usuario;
import com.wolftech.louvorsheknah.entity.enums.Tipo;
import com.wolftech.louvorsheknah.exception.ObjectNotFoundException;
import com.wolftech.louvorsheknah.mapper.RepertorioCadastroMapper;
import com.wolftech.louvorsheknah.mapper.RepertorioMapper;
import com.wolftech.louvorsheknah.repositories.RepertorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RepertorioService {

    private final RepertorioRepository repository;
    private final RepertorioCadastroMapper cadastroMapper;
    private final RepertorioMapper mapper;
    private final UsuarioService usuarioService;
    private final LogService logService;


    public Repertorio salvar(RepertorioCadastroDTO dto) {
        Repertorio repertorio = cadastroMapper.toEntity(dto);
        Usuario usuario = usuarioService.buscarPorEmail(dto.getEmailUsuario());
        repertorio.setDataCriacao(LocalDateTime.now());
        repertorio.setUsuario(usuario);
        Log log = new Log();
        log.setAutor(usuario.getNome());
        log.setIdObjeto(usuario.getId());
        log.setDescricao("Novo repertório criado " + repertorio.getNome());
        log.setTipo(Tipo.ITEM);
        logService.salvar(log);
        return repository.save(repertorio);
    }


    public List<Repertorio> listarTudo() {
        return repository.findAll();
    }

    public Repertorio editar(RepertorioDTO dto) {
        buscarPeloId(dto.getId());
        return repository.save(mapper.toEntity(dto));
    }

    public Repertorio buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuário não localizado pelo id: " + id)
        );
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        repository.deleteById(id);
    }

    public Repertorio adicionarItems(Long idRepertorio, Set<Musica> musicas) {
        Repertorio repertorio = buscarPeloId(idRepertorio);
        for (Musica musica : musicas) {
            if (!repertorio.getMusicas().contains(musica)) {
                repertorio.getMusicas().add(musica);
            }
        }
        return repository.save(repertorio);
    }

    public Repertorio removerItems(Long idRepertorio, Set<Musica> funcionarios) {
        Repertorio repertorio = buscarPeloId(idRepertorio);
        for (Musica musica : funcionarios) {
            repertorio.getMusicas().removeIf(f -> (f.getId().equals(musica.getId())));
        }
        return repository.save(repertorio);
    }

}

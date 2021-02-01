package com.dev4abyss.louvorsheknah.services;

import com.dev4abyss.louvorsheknah.dto.RepertorioCadastroDTO;
import com.dev4abyss.louvorsheknah.dto.RepertorioDTO;
import com.dev4abyss.louvorsheknah.entity.Log;
import com.dev4abyss.louvorsheknah.entity.Musica;
import com.dev4abyss.louvorsheknah.entity.Repertorio;
import com.dev4abyss.louvorsheknah.entity.Usuario;
import com.dev4abyss.louvorsheknah.entity.enums.Tipo;
import com.dev4abyss.louvorsheknah.exception.ObjectNotFoundException;
import com.dev4abyss.louvorsheknah.mapper.RepertorioCadastroMapper;
import com.dev4abyss.louvorsheknah.mapper.RepertorioMapper;
import com.dev4abyss.louvorsheknah.repositories.RepertorioRepository;
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

    public List<Repertorio> buscarTodosPorMusica(Musica musica) {
        return repository.findAllByMusicasContains(musica);
    }

    public void salvarTodos(List<Repertorio> repertorios) {
        repository.saveAll(repertorios);
    }
}

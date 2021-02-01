package com.wolftech.louvorsheknah.services;

import com.wolftech.louvorsheknah.dto.MusicaCadastroDTO;
import com.wolftech.louvorsheknah.dto.MusicaDTO;
import com.wolftech.louvorsheknah.entity.Musica;
import com.wolftech.louvorsheknah.entity.Log;
import com.wolftech.louvorsheknah.entity.Usuario;
import com.wolftech.louvorsheknah.entity.enums.Tipo;
import com.wolftech.louvorsheknah.exception.ObjectNotFoundException;
import com.wolftech.louvorsheknah.mapper.ItemCadastroMapper;
import com.wolftech.louvorsheknah.mapper.MusicaMapper;
import com.wolftech.louvorsheknah.repositories.MusicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicaService {

    private final MusicaRepository repository;
    private final MusicaMapper mapper;
    private final ItemCadastroMapper cadastroMapper;
    private final LogService logService;
    private final UsuarioService usuarioService;

    public Musica salvar(MusicaCadastroDTO dto) {
        Usuario usuario = usuarioService.buscarPorEmail(dto.getEmailUsuario());
        Musica musica = cadastroMapper.toEntity(dto);
        musica.setUsuario(usuario);
        repository.save(musica);

        Log log = new Log();
        log.setAutor(usuario.getNome());
        log.setIdObjeto(usuario.getId());
        log.setDescricao((dto.getId()!=null? "Atualização nas informações da música": "Nova música adicionada ao repertório: ") + musica.getNome());
        log.setTipo(Tipo.ITEM);

        return musica;
    }

    public List<Musica> listarTudo() {
        List<Musica> musicas = repository.findAll();
        musicas.sort(Comparator.comparing(Musica::getId));
        return musicas;
    }

    public List<Musica> buscarTodasPeloNome(String nome) {
        return repository.findAllByNomeContainsIgnoreCase(nome);
    }

    public Musica buscarPeloNome(String nome) {
        return repository.findByNome(nome);
    }

    public Musica editarItem(MusicaDTO dto) {
        buscarPorId(dto.getId());
        return repository.save(mapper.toEntity(dto));
    }

    public Musica buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuário não localizado pelo id: " + id)
        );
    }

    public void deletarItem(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

}

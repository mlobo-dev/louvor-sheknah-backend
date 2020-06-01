package com.wolftech.louvorsheknah.services;

import com.wolftech.louvorsheknah.dto.ItemCadastroDTO;
import com.wolftech.louvorsheknah.dto.ItemDTO;
import com.wolftech.louvorsheknah.entity.Item;
import com.wolftech.louvorsheknah.entity.Log;
import com.wolftech.louvorsheknah.entity.Usuario;
import com.wolftech.louvorsheknah.entity.enums.Tipo;
import com.wolftech.louvorsheknah.exception.ObjectNotFoundException;
import com.wolftech.louvorsheknah.mapper.ItemCadastroMapper;
import com.wolftech.louvorsheknah.mapper.ItemMapper;
import com.wolftech.louvorsheknah.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;
    private final ItemMapper mapper;
    private final ItemCadastroMapper cadastroMapper;
    private final LogService logService;
    private final UsuarioService usuarioService;

    public Item salvar(ItemCadastroDTO dto) {
        Usuario usuario = usuarioService.buscarPorId(dto.getIdUsuario());
        Item item = cadastroMapper.toEntity(dto);
        item.setUsuario(usuario);
        repository.save(item);

        Log log = new Log();
        log.setAutor(usuario.getNome());
        log.setIdObjeto(usuario.getId());
        log.setDescricao("Nova música adicionada ao repertório: " + item.getNome());
        log.setTipo(Tipo.ITEM);
        logService.salvar(log);
        return item;
    }

    public List<Item> listarTudo() {
        return repository.findAll();
    }

    public List<Item> buscarTodasPeloNome(String nome) {
        return repository.findAllByNomeContainsIgnoreCase(nome);
    }

    public Item buscarPeloNome(String nome){
        return  repository.findByNome(nome);
    }

    public Item editarItem(ItemDTO dto) {
        buscarPorId(dto.getId());
        return repository.save(mapper.toEntity(dto));
    }

    public Item buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuário não localizado pelo id: " + id)
        );
    }

    public void deletarItem(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

}

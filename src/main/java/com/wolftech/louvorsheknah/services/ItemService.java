package com.wolftech.louvorsheknah.services;

import com.wolftech.louvorsheknah.dto.ItemDTO;
import com.wolftech.louvorsheknah.exception.ObjectNotFoundException;
import com.wolftech.louvorsheknah.mapper.ItemMapper;
import com.wolftech.louvorsheknah.entity.Item;
import com.wolftech.louvorsheknah.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ItemMapper mapper;

    public Item salvar(ItemDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public List<Item> listarTudo() {
        return repository.findAll();
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

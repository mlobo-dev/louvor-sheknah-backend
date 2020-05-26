package com.wolftech.louvorsheknah.services;

import com.wolftech.louvorsheknah.dto.UsuarioDTO;
import com.wolftech.louvorsheknah.entity.Usuario;
import com.wolftech.louvorsheknah.exception.AuthException;
import com.wolftech.louvorsheknah.exception.ObjectNotFoundException;
import com.wolftech.louvorsheknah.mapper.UsuarioMapper;
import com.wolftech.louvorsheknah.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    public Usuario salvar(UsuarioDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public List<Usuario> listarTudo() {
        return repository.findAll();
    }

    public Usuario editarUsuario(UsuarioDTO dto) {
        buscarPorId(dto.getId());
        return repository.save(mapper.toEntity(dto));
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuário não localizado pelo id: " + id)
        );
    }

    public void deletarUsuario(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    public Usuario autenticar(String emailOuLogin, String senha) {
        Optional<Usuario> usuario = repository.findByEmailOrLogin(emailOuLogin, emailOuLogin);
        if (!usuario.isPresent()) {
            throw new AuthException("Usuário não encontrado: " );
        }

        if (!usuario.get().getSenha().equals(senha)) {
            throw new AuthException("Senha Inválida.");
        }
        return usuario.get();
    }
}

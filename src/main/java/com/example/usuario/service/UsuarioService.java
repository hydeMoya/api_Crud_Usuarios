package com.example.usuario.service;

import java.util.List;

import com.example.usuario.entity.Usuario;

public interface UsuarioService {

    public Usuario save(Usuario usuario);

    public List<Usuario> findAll();

    public Usuario findById(Long id);

    public List<Usuario> findByAllId(List<Long> ids);

    public List<Usuario> findByGenderAndAge(String gender,Long age);

    public void deleteById(Long id);
    
}

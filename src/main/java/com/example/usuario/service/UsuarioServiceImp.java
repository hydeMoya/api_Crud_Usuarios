package com.example.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usuario.entity.Usuario;
import com.example.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        // TODO Auto-generated method stub
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        // TODO Auto-generated method stub
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        // TODO Auto-generated method stub
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> findByAllId(List<Long> ids) {
        // TODO Auto-generated method stub
        return usuarioRepository.findAllById(ids);
    }

    @Override
    public List<Usuario> findByGenderAndAge(String gender,Long age) {
        // TODO Auto-generated method stub
        return usuarioRepository.findByGenderAndAge(gender, age);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        usuarioRepository.deleteById(id);
    }
    
}

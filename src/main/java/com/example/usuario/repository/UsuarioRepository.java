package com.example.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.usuario.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
    Usuario usuario = new Usuario();
    @Transactional(readOnly = true)
    @Query("SELECT u FROM Usuario u WHERE u.gender LIKE %?1% and u.age=?2")
	public List<Usuario> findByGenderAndAge(String gender, Long age);
}

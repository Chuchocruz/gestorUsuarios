package com.cursojava.curso.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojava.curso.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional

public class UsuarioDaoimp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
       
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();

       

        

    }

    @Override
    public void eliminarUsuario(Long id) {

        Usuario usuario = entityManager.find(Usuario.class, id);
        
        entityManager.remove(usuario);
    }





}

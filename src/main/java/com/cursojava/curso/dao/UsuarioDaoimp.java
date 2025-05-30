package com.cursojava.curso.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojava.curso.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public void registrar(Usuario usuario) {
        
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUserPorCredencial(Usuario usuario) {

        String query = "FROM Usuario WHERE email = :email ";

        List<Usuario> lista = entityManager.createQuery(query)
                    .setParameter("email", usuario.getEmail())
                    
                    .getResultList();

                    if (lista.isEmpty()) {
                        return null;
                    }

                    String passwordHass = lista.get(0).getPassword();

                    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                    if (argon2.verify(passwordHass, usuario.getPassword())){
                        return lista.get(0);
                    }
                    return null;
                    


    }




    





}

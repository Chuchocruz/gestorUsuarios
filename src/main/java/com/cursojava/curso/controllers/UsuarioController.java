package com.cursojava.curso.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

// import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id){


        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Jose");
        usuario.setApellido("Gonzalez");
        usuario.setEmail("jose12@gmail.com");
        usuario.setTelefono("5549124873");
        usuario.setPassword("chucho123");

        return usuario;


    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios() {

        return usuarioDao.getUsuarios();
    }




    





    @RequestMapping(value = "usuario11")
    public Usuario editarUsuario(){


        Usuario usuario = new Usuario();
        usuario.setNombre("Jose");
        usuario.setApellido("Gonzalez");
        usuario.setEmail("jose12@gmail.com");
        usuario.setTelefono("5549124873");
        usuario.setPassword("chucho123");

        return usuario;


    }


    @DeleteMapping("api/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Long id){

        usuarioDao.eliminarUsuario(id);

    }

    @RequestMapping(value = "usuario33")
    public Usuario buscarUsuario(){


        Usuario usuario = new Usuario();
        usuario.setNombre("Jose");
        usuario.setApellido("Gonzalez");
        usuario.setEmail("jose12@gmail.com");
        usuario.setTelefono("5549124873");
        usuario.setPassword("chucho123");

        return usuario;


    }

}

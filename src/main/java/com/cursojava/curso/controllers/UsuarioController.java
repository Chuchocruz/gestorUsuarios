package com.cursojava.curso.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

// import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;




@RestController
public class UsuarioController {

    @Autowired      //automaticamente hace que la clase cree un objeto y la guarda en la variable
    private UsuarioDao usuarioDao;  //inyeccion de dependencias

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
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
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {

        String usuarioid = jwtUtil.getKey(token);
        if (!validarToken(token)) {
            return null;
        }

        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioid = jwtUtil.getKey(token);
        return usuarioid != null;

    }




    //Nuevo metodo registrar
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        
        usuarioDao.registrar(usuario);
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


    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    // @DeleteMapping("api/usuarios/{id}")
    public void eliminarUsuario(@RequestHeader(value="Authorization") String token, 
                                @PathVariable Long id){

        if (!validarToken(token)) {
            return;
        }
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

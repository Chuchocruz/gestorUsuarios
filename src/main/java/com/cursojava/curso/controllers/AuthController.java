package com.cursojava.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;

@RestController

public class AuthController {

     @Autowired
     private UsuarioDao usuarioDao;

     @Autowired
     private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        
        Usuario userLogueado = usuarioDao.obtenerUserPorCredencial(usuario);

        if( userLogueado != null){

            String tokenjwt = jwtUtil.create(String.valueOf(userLogueado.getId()), userLogueado.getEmail());


            return tokenjwt;
        }
        return "FAIL";
    }

}

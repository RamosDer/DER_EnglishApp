package com.my_company.eapp.services;

import com.my_company.eapp.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    Usuario getUserByUsername(String username);
    int createUsuario(Usuario usuario);
    int updateUsuario(Usuario usuario);
    int deleteUsuario(Integer id);
    boolean validarCredenciales(String username, String password);
    boolean doesUsernameExist(String username);
}


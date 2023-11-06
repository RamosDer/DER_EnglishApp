package com.my_company.eapp.services.impl;

/*
package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.UsuarioMapper;
import com.my_company.eapp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UserDetailsServiceImpl(UsuarioMapper usuarioMapper)  {
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Ingresa a loadUserByUsername - UserDetailsServiceImpl");
        Usuario usuario = this.usuarioMapper.selectUsuarioByNombreUsuario(username);
        System.out.println("Usuario" + usuario);
        if(usuario == null){
            System.out.println("Ingresa al if usuario == null");
            throw new UsernameNotFoundException("UserDetailsServiceImpl - Usuario no encontrado");
        }
        System.out.println("Procede a retornar el usuario");
        return (UserDetails) usuario;
    }

}
*/
package com.my_company.eapp.services.impl;

//import com.my_company.eapp.resources.IngresaPalabraResource;
import com.my_company.eapp.dao.UsuarioMapper;
import com.my_company.eapp.jwt.conf.UserDetailsImpl;
import com.my_company.eapp.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    private static final Logger logger = LogManager.getLogger(UserDetailServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Ingresa a loadUserByUsername - UserDetailsServiceImpl");
        Usuario usuario = this.usuarioMapper.selectUsuarioByNombreUsuario(username);
        logger.info("Usuario" + usuario.getNombreUsuario());
        if(usuario == null){
            logger.info("Ingresa al if usuario == null");
            throw new UsernameNotFoundException("UserDetailsServiceImpl - Usuario no encontrado");
        }
        logger.info("Procede a retornar el usuario");
        return new UserDetailsImpl(usuario);
    }
}

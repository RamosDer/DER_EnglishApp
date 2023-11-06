package com.my_company.eapp.services.impl;

//import com.my_company.eapp.resources.IngresaPalabraResource;
import com.my_company.eapp.dao.UsuarioMapper;
import com.my_company.eapp.model.Usuario;
import com.my_company.eapp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    
    private static final Logger logger = LogManager.getLogger(UsuarioServiceImpl.class);
    
     @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioMapper.selectByExample(null);
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuarioMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createUsuario(Usuario usuario) {
        logger.info("Ingresa al metodo createUsuario - ServiceImpl");
        usuario.setContrasenha(bCryptPasswordEncoder.encode(usuario.getContrasenha()));
        return usuarioMapper.insertSelective(usuario);
    }

    @Override
    public int updateUsuario(Usuario usuario) {
        return usuarioMapper.updateByPrimaryKeySelective(usuario);
    }

    @Override
    public int deleteUsuario(Integer id) {
        return usuarioMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean validarCredenciales(String nombreUsuario, String contrasenha) {
        // Buscar al usuario por nombre de usuario en la base de datos
        Usuario usuario = usuarioMapper.selectUsuarioByNombreUsuario(nombreUsuario);

        if (usuario != null) {
            // Verificar si la contraseña coincide (debes implementar la lógica de hashing y salting)
            if (verificarContraseña(contrasenha, usuario.getContrasenha())) {
                return true; // Credenciales válidas
            }
        }

        return false; // Credenciales inválidas
    }

    @Override
    public boolean doesUsernameExist(String username) {
        return usuarioMapper.doesUsernameExist(username) > 0;
    }

    // Método para verificar la contraseña (debes implementar esta lógica)
    private boolean verificarContraseña(String inputPassword, String hashedPassword) {
        // Implementa la lógica de comparación segura de contraseñas aquí
        // Puedes utilizar bibliotecas de seguridad como BCrypt
        // Devuelve true si las contraseñas coinciden, false si no
        // ¡Asegúrate de implementar esto correctamente!
        return BCrypt.checkpw(inputPassword, hashedPassword);
    }
    
    
}

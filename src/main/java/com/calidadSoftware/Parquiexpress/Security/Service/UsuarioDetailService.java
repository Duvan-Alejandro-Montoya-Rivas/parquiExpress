package com.calidadSoftware.Parquiexpress.Security.Service;

import com.calidadSoftware.Parquiexpress.Security.Entity.Usuario;
import com.calidadSoftware.Parquiexpress.Security.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioDetailService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUsernameOrEmail(username, username);
        if(!usuario.isPresent())
            throw new UsernameNotFoundException("no existe");
        return UsuarioPrincipal.build(usuario.get());
    }
}

package com.calidadSoftware.Parquiexpress.Security.Service;
import com.calidadSoftware.Parquiexpress.Global.Exceptions.AttributeException;
import com.calidadSoftware.Parquiexpress.Security.Dto.CreateUsuarioDTO;
import com.calidadSoftware.Parquiexpress.Security.Dto.JwtTokenDto;
import com.calidadSoftware.Parquiexpress.Security.Dto.LogInUsuarioDto;
import com.calidadSoftware.Parquiexpress.Security.Entity.Usuario;
import com.calidadSoftware.Parquiexpress.Security.Enums.Roles;
import com.calidadSoftware.Parquiexpress.Security.Repository.UsuarioRepository;
import com.calidadSoftware.Parquiexpress.Security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    public Usuario create(CreateUsuarioDTO dto) throws AttributeException {
        if(usuarioRepository.existsByUsername(dto.getUsername()))
            throw new AttributeException("Usuario ya registrado");
        if(usuarioRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("Email ya registrado");
        if(dto.getRoles().isEmpty()){
            throw new AttributeException("Rol es obligatorio");
        }
        return usuarioRepository.save(MapeoDeUsuario(dto));
    }

    public Usuario createAdmin(CreateUsuarioDTO dto) throws AttributeException {
        if(usuarioRepository.existsByUsername(dto.getUsername()))
            throw new AttributeException("Usuario ya registrado");
        if(usuarioRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("Email ya registrado");

        List<String> roles = Arrays.asList("ROLE_ADMIN","ROLE_USER");
        dto.setRoles(roles);
        return usuarioRepository.save(MapeoDeUsuario(dto));
    }

    public Usuario createUser(CreateUsuarioDTO dto) throws AttributeException {
        if(usuarioRepository.existsByUsername(dto.getUsername()))
            throw new AttributeException("Usuario ya registrado");
        if(usuarioRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("Email ya registrado");
        List<String> roles = Arrays.asList("ROLE_USER");
        dto.setRoles(roles);
        return usuarioRepository.save(MapeoDeUsuario(dto));
    }



    public JwtTokenDto login(LogInUsuarioDto dto){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new JwtTokenDto(token);
    }

    private Usuario MapeoDeUsuario(CreateUsuarioDTO dto){
        String password = passwordEncoder.encode(dto.getPassword());
        int id = Autoincrement();
        List<Roles> roles =
                dto.getRoles().stream().map(rol -> Roles.valueOf(String.valueOf(rol))).collect(Collectors.toList());
        return new Usuario(id,dto.getUsername(), dto.getCellphone(), dto.getAge(), dto.getUserid(), dto.getEmail(), password, roles);
    }

    public List<Usuario> encontraTodo(){return usuarioRepository.findAll();}

    private int Autoincrement(){
        List<Usuario> users = usuarioRepository.findAll();
        return users.isEmpty()? 1:
                users.stream().max(Comparator.comparing(Usuario::getId)).get().getId() +1;
    }

}

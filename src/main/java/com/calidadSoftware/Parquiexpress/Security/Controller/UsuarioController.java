package com.calidadSoftware.Parquiexpress.Security.Controller;

import com.calidadSoftware.Parquiexpress.Global.Exceptions.AttributeException;
import com.calidadSoftware.Parquiexpress.Global.Mensajes.mensajesDto;
import com.calidadSoftware.Parquiexpress.Security.Dto.CreateUsuarioDTO;
import com.calidadSoftware.Parquiexpress.Security.Dto.JwtTokenDto;
import com.calidadSoftware.Parquiexpress.Security.Dto.LogInUsuarioDto;
import com.calidadSoftware.Parquiexpress.Security.Entity.Usuario;
import com.calidadSoftware.Parquiexpress.Security.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/create-prueba")
    public ResponseEntity<mensajesDto> create (@Valid @RequestBody CreateUsuarioDTO createUsuarioDTO) throws AttributeException {
        Usuario usuario = usuarioService.create(createUsuarioDTO);
        return ResponseEntity.ok (new mensajesDto("El Usuario "+
                usuario.getUsername()+" Fue Satisfactoria mente Creado",HttpStatus.OK));
    }

    @PostMapping("/admin")
    public ResponseEntity<mensajesDto> createAdmin (@Valid @RequestBody CreateUsuarioDTO createUsuarioDTO) throws AttributeException {
        Usuario usuario = usuarioService.createAdmin(createUsuarioDTO);
        return ResponseEntity.ok (new mensajesDto("El Administrador "+
                usuario.getUsername()+" Fue Satisfactoria mente Creado",HttpStatus.OK));
    }

    @PostMapping("/user")
    public ResponseEntity<mensajesDto> createUser (@Valid @RequestBody CreateUsuarioDTO createUsuarioDTO) throws AttributeException {
        Usuario usuario = usuarioService.createUser(createUsuarioDTO);
        return ResponseEntity.ok (new mensajesDto("El Usuario "+
                usuario.getUsername()+" Fue Satisfactoria mente Creado",HttpStatus.OK));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login (@Valid @RequestBody LogInUsuarioDto logInUsuarioDto) throws AttributeException{
        JwtTokenDto jwtTokenDto = usuarioService.login(logInUsuarioDto);
        return ResponseEntity.ok (jwtTokenDto);
    }


    @PreAuthorize("hasRole ('ROLE_ADMIN')")
    @GetMapping("/prueba")
    public List<Usuario> retornaTodo(){
        return usuarioService.encontraTodo();
    }


}

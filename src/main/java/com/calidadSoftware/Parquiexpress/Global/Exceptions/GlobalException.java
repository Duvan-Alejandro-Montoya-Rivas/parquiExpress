package com.calidadSoftware.Parquiexpress.Global.Exceptions;

import com.calidadSoftware.Parquiexpress.Global.Mensajes.mensajesDto;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<mensajesDto> throwNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new mensajesDto(e.getMessage(), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<mensajesDto> throwAttributeException(AttributeException e) {
        return ResponseEntity.badRequest()
                .body(new mensajesDto(e.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<mensajesDto> generalException(Exception e) {
        return ResponseEntity.internalServerError()
                .body(new mensajesDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity <mensajesDto> badCredentialsException(BadCredentialsException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new mensajesDto("Credenciales incorrectas", HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity <mensajesDto> accesDeniedExceprion(AccessDeniedException deniedException){
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new mensajesDto("No tienes Acceso a este recurso", HttpStatus.FORBIDDEN));
    }
}
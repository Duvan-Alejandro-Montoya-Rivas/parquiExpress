package com.calidadSoftware.Parquiexpress.Security.jwt;
import com.calidadSoftware.Parquiexpress.Global.Mensajes.mensajesDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("token not found or invalid");
        mensajesDto mensajesDto =new mensajesDto("Token no encontrado o invalido",HttpStatus.UNAUTHORIZED);
        response.setContentType("application/json");
        response.setStatus(mensajesDto.getHttpStatus().value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(mensajesDto));
        response.getWriter().flush();
        response.getWriter().close();
    }

}

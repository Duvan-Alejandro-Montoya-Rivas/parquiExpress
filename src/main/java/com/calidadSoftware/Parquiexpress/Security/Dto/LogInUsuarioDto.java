package com.calidadSoftware.Parquiexpress.Security.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogInUsuarioDto {
    @NotBlank(message = "Obligatorio el nombre de usuario")
    private String username;
    @NotBlank(message = "Obligatorio la contrasena de usuario")
    private String password;
}

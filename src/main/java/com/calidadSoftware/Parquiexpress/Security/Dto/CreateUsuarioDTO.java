package com.calidadSoftware.Parquiexpress.Security.Dto;


import com.calidadSoftware.Parquiexpress.Security.Enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUsuarioDTO {
    @NotBlank(message = "Obligatorio el nombre de usuario")
    private String username;
    @NotBlank(message = "Obligatorio el telefono de usuario")
    private String cellphone;
    @NotBlank(message = "Obligatorio la edad de usuario")
    private String age;
    @NotBlank(message = "Obligatorio la identificacion de usuario")
    private String userid;
    @Email(message = "Obligatorio el email de usuario")
    private String email;
    @NotBlank(message = "Obligatorio la contrasena de usuario")
    private String password;
    //@NotEmpty(message = "Rol es obligatorio")
    private List<String> roles = new ArrayList<>();


}

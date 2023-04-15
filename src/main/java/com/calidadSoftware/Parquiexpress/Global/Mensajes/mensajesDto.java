package com.calidadSoftware.Parquiexpress.Global.Mensajes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class mensajesDto{

    private String message;
    private HttpStatus httpStatus;

}

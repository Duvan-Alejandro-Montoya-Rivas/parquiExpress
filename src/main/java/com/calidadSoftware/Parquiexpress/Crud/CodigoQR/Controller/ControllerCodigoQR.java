package com.calidadSoftware.Parquiexpress.Crud.CodigoQR.Controller;

import com.calidadSoftware.Parquiexpress.Crud.CodigoQR.Entity.CodigoQR;
import com.calidadSoftware.Parquiexpress.Crud.CodigoQR.Service.ServiceCodigoQR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codigoqr")
public class ControllerCodigoQR {
    @Autowired
    private ServiceCodigoQR serviceCodigoQR;
    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/CodigosQR/QRCode.png";

    @PreAuthorize("hasRole ('ROLE_ADMIN')")
    @PostMapping
    public CodigoQR download(@RequestBody CodigoQR codigoQR ) throws Exception {
        ServiceCodigoQR.generateQRCodeImage(codigoQR.getUrl(),
                codigoQR.getWidth(), codigoQR.getHeight(), QR_CODE_IMAGE_PATH);
        generateQRCode(codigoQR);
        return serviceCodigoQR.GuardarQR(codigoQR);
    }
    private ResponseEntity<byte[]> generateQRCode(CodigoQR codigoQR )
            throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                ServiceCodigoQR.getQRCodeImage(codigoQR.getUrl(), 350, 350));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public List<CodigoQR> ObtenerCodigos(){
        return serviceCodigoQR.ObtenerCodigos();
    }
}

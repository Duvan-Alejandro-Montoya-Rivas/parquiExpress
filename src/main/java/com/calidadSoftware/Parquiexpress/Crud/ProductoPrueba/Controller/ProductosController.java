package com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Controller;

import com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Entity.Productos;
import com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @PreAuthorize("hasRole ('ROLE_ADMIN')")
    @PostMapping
    public Productos save(@RequestBody Productos productos){
        return productosService.save(productos);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public List<Productos> productos(){
        return productosService.ObtenerProductos();
    }
}

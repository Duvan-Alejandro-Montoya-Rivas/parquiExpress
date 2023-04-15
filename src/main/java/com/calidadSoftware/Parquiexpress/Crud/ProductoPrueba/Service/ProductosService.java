package com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Service;


import com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Entity.Productos;
import com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;


    public Productos save(Productos productos){
        return productosRepository.save(productos);
    }
    public List<Productos> ObtenerProductos(){
        return productosRepository.findAll();
    }
}
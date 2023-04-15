package com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Repository;

import com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}

package com.calidadSoftware.Parquiexpress.Crud.ProductoPrueba.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(unique = true, nullable = false)
    private String nameproduct;
    @Column(unique = true, nullable = false)
    private int cantidad;
}

package com.calidadSoftware.Parquiexpress.Crud.CodigoQR.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CodigoQR")
public class CodigoQR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "width", nullable = false)
    private int width;
    @Column(name = "height", nullable = false)
    private int height;
    @Column(name = "vigencia", nullable = false)
    private Boolean vigencia;
    @Column(name="id_TX", nullable = false)
    private Long id_taxi;
}

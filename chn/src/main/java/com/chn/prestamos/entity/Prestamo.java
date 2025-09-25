package com.chn.prestamos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
public class Prestamo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal montoTotal;

    @Column(nullable = false)
    private Integer plazoMeses;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaAnual;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private OffsetDateTime fechaSolicitud;

    @PrePersist
    void prePersist() {
        if (fechaSolicitud == null) fechaSolicitud = OffsetDateTime.now();
        if (estado == null) estado = "PENDIENTE";
    }
    private String observacionEstado;

}

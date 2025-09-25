package com.chn.prestamos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @ManyToOne(optional = false) @JoinColumn(name ="prestamo_id") private Prestamo prestamo;
    @Column(nullable = false, precision = 18, scale = 2) private BigDecimal montoPagado;
    @Column(nullable = false) private OffsetDateTime fechaPago = OffsetDateTime.now();

}


package com.chn.prestamos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @Column(nullable = false, length =100 ) private String nombres;
    @Column(nullable = false, length = 100) private String apellidos;
    @Column(nullable = false, unique = true,length = 20) private String dpi;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String email;
    private String telefono;
}
package com.chn.prestamos.controller;

import com.chn.prestamos.dto.PagosDTO;
import com.chn.prestamos.entity.Pago;
import com.chn.prestamos.entity.Prestamo;
import com.chn.prestamos.repository.PagoRepository;
import com.chn.prestamos.repository.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final PagoRepository pagoRepository;
    private final PrestamoRepository prestamoRepository;

    @PostMapping
    public Pago registrar(@RequestBody PagosDTO pagosDTO){
        Prestamo p = prestamoRepository.findById(pagosDTO.prestamo_id()).orElseThrow();
        Pago pago = new Pago(); pago.setPrestamo(p); pago.setMontoPagado(pagosDTO.monto_pagado());
        return pagoRepository.save(pago);
    }
    @GetMapping("/prestamo/{prestamoId}")
    public List<Pago> porPrestamo(@PathVariable Integer prestamoId){
        return pagoRepository.findByPrestamoId(prestamoId);
    }
}

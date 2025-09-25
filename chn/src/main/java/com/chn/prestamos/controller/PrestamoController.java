package com.chn.prestamos.controller;

import com.chn.prestamos.dto.CambioEstadoDTO;
import com.chn.prestamos.dto.PrestamoSolicitudDTO;
import com.chn.prestamos.entity.Prestamo;
import com.chn.prestamos.repository.PrestamoRepository;
import com.chn.prestamos.services.PrestamoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@RequiredArgsConstructor
public class PrestamoController {
    private final PrestamoService service;
    private final PrestamoRepository repository;

    @GetMapping
    public List<Prestamo> all() { return repository.findAll(); }

    @GetMapping("/cliente/{clienteId}")
    public List<Prestamo> porCliente(@PathVariable Integer clienteId) {
        return repository.findByClienteId(clienteId);
    }
    // ...
}

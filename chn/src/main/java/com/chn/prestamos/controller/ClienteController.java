package com.chn.prestamos.controller;

import ch.qos.logback.core.net.server.Client;
import com.chn.prestamos.entity.Cliente;
import com.chn.prestamos.repository.ClienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteRepository repository;

    @GetMapping public List<Cliente> all() {return repository.findAll();}
    @PostMapping public Cliente create(@Valid @RequestBody Cliente cliente){ return repository.save(cliente);}

    @PutMapping("/{id}")
    public  Cliente update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente db = repository.findById(id).orElseThrow();
        db.setNombres(cliente.getNombres()); db.setApellidos(cliente.getApellidos());
        db.setDpi(cliente.getDpi()); db.setFechaNacimiento(cliente.getFechaNacimiento());
        db.setDireccion(cliente.getDireccion()); db.setEmail(cliente.getEmail());
        db.setTelefono(cliente.getTelefono());
        return  repository.save(db);

    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Integer id){ repository.deleteById(id); }
}

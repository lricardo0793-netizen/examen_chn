package com.chn.prestamos.repository;

import com.chn.prestamos.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    List<Prestamo> findByClienteId(Integer clienteId);
}

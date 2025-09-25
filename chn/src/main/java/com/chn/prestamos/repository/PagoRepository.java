package com.chn.prestamos.repository;

import com.chn.prestamos.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface PagoRepository extends JpaRepository<Pago, Integer> {
    @Query("select coalesce(sum(p.montoPagado),0) from Pago p where p.prestamo.id=:prestamoId")
    BigDecimal totalPagado(@Param("prestamoId") Integer prestamoId);
    List<Pago> findByPrestamoId(Integer prestamoId);
}

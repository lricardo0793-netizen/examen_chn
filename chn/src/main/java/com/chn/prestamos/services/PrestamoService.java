package com.chn.prestamos.services;

import com.chn.prestamos.dto.CambioEstadoDTO;
import com.chn.prestamos.dto.PrestamoSolicitudDTO;
import com.chn.prestamos.entity.Prestamo;
import com.chn.prestamos.repository.ClienteRepository;
import com.chn.prestamos.repository.PagoRepository;
import com.chn.prestamos.repository.PrestamoRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Data
public class PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final PagoRepository pagoRepository;
    private final ClienteRepository clienteRepository;

    public Prestamo solicitar(PrestamoSolicitudDTO dto){
        var cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Prestamo p = new Prestamo();
        p.setCliente(cliente);
        p.setMontoTotal(dto.montototal());
        p.setPlazoMeses(dto.plazoMeses());
        p.setTasaAnual(dto.tasaAnual());
        p.setEstado("PENDIENTE");
        return prestamoRepository.save(p);
    }

    public Prestamo cambiarEstado(Integer id, CambioEstadoDTO dto){
        Prestamo p = prestamoRepository.findById(id).orElseThrow();
        p.setEstado(dto.estado());
        p.setObservacionEstado(dto.observacionEstado());
        return  prestamoRepository.save(p);
    }

    public BigDecimal saldoPendiente(Integer prestamoId){
        var p = prestamoRepository.findById(prestamoId).orElseThrow();
        BigDecimal pagado = pagoRepository.totalPagado(prestamoId);
        BigDecimal saldo = p.getMontoTotal().subtract(pagado);
        return saldo.compareTo(BigDecimal.ZERO) <0 ? BigDecimal.ZERO : saldo ;
    }
}


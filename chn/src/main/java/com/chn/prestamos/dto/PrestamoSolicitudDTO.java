package com.chn.prestamos.dto;

public record PrestamoSolicitudDTO(
    Integer clienteId,
    java.math.BigDecimal montototal,
    Integer plazoMeses,
    java.math.BigDecimal tasaAnual

){}

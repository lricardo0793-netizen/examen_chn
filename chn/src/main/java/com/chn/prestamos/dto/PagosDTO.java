package com.chn.prestamos.dto;


import java.math.BigDecimal;

public record PagosDTO(
        Integer prestamo_id,
        BigDecimal monto_pagado
) {}

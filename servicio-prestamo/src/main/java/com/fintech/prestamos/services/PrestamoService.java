package com.fintech.prestamos.services;

import com.fintech.prestamos.model.Prestamo;

import java.util.List;

public interface PrestamoService {

    List<Prestamo> findByCodCliente(Integer codCliente);

    Prestamo findByCodClienteAndCodPrestamo(Integer codCliente, Integer codPrestamo);

    Prestamo create(Prestamo prestamo);

    void update(Prestamo prestamo);
}

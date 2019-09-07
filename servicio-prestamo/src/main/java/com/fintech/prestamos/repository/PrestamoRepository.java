package com.fintech.prestamos.repository;

import com.fintech.prestamos.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    List<Prestamo> findByCodCliente(Integer codCliente);

    Prestamo findByCodClienteAndCodPrestamo(Integer codCliente, Integer codPrestamo);
}

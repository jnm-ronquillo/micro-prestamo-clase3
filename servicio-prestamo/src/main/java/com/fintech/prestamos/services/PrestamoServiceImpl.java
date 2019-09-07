package com.fintech.prestamos.services;

import com.fintech.prestamos.model.Prestamo;
import com.fintech.prestamos.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> findByCodCliente(Integer codCliente) {
        return prestamoRepository.findByCodCliente(codCliente);
    }

    @Override
    public Prestamo findByCodClienteAndCodPrestamo(Integer codCliente, Integer codPrestamo) {
        return prestamoRepository.findByCodClienteAndCodPrestamo(codCliente, codPrestamo);
    }

    @Override
    @Transactional
    public Prestamo create(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    @Transactional
    public void update(Prestamo prestamo) {
        prestamoRepository.save(prestamo);
    }
}

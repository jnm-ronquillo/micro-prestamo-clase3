package com.fintech.prestamos.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fintech.prestamos.config.FintechConfig;
import com.fintech.prestamos.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.prestamos.model.Prestamo;

@RestController
@RequestMapping(path="v1/clientes/{codCliente}/prestamos")
public class PrestamoController {

	@Autowired
	FintechConfig fintechConfig;

	@Autowired
	PrestamoService prestamoService;

	@GetMapping("")
	public List<Prestamo> getPrestamos(@PathVariable Integer codCliente) {
		return prestamoService.findByCodCliente(codCliente);
	}


	@GetMapping("/{codPrestamo}")
	public Prestamo getPrestamo(@PathVariable Integer codCliente, @PathVariable Integer codPrestamo) {
		return prestamoService.findByCodClienteAndCodPrestamo(codCliente, codPrestamo);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
		return prestamoService.create(prestamo);
	}

	@PutMapping("/{codPrestamo}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePrestamo(@PathVariable Integer codPrestamo, @RequestBody Prestamo prestamo) {
		prestamo.setCodPrestamo(codPrestamo);
		prestamoService.update(prestamo);
	}

	@GetMapping("/check/env")
	public String testEnv() {
		return fintechConfig.getPropiedadEjemplo();
	}
	

}

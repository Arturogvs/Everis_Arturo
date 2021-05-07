package com.everis.sumativa2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa2.models.Carrito;
import com.everis.sumativa2.repositories.CarritoRepository;

@Service
public class CarritoService {

	@Autowired
	CarritoRepository carritoRepository;

	public Object listaCarrito() {
		// TODO Auto-generated method stub
		return carritoRepository.findAll();
	}

	public void agregarCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		
		carritoRepository.save(carrito);
		
	}

	public Carrito buscarCarrito(Long id) {
		// TODO Auto-generated method stub
		return carritoRepository.findById(id).get();
	}

	public void quitarProducto(Long id) {
		// TODO Auto-generated method stub
		carritoRepository.deleteById(id);;
	}
	
	
	
	
}

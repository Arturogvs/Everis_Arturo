package com.everis.sumativa2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa2.models.Producto;
import com.everis.sumativa2.repositories.ProductoRepository;

@Service
public class ProductoService {
 @Autowired
 	ProductoRepository productoRepository;
 
	public Producto ingresarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	public Producto buscarProducto(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}



}

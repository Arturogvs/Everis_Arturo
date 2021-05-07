package com.everis.sumativa2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa2.models.Carrito;
import com.everis.sumativa2.models.Producto;
import com.everis.sumativa2.services.CarritoService;
import com.everis.sumativa2.services.ProductoService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	CarritoService carritoService;
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("/listar")
	public String listarCarrito(Model model) {
		
		model.addAttribute("lista_carrito",carritoService.listaCarrito());
		
		
		return "/Carrito/listaCarrito.jsp";
	}
	
	@RequestMapping("/agregar/{id}")
	public String agregarCarrito(@PathVariable("id") Long id) {
		
		
		Carrito carrito = new Carrito();
		Producto product = new Producto();
		
		product=productoService.buscarProducto(id);
		carrito.setProducto_id(product.getId());
		carrito.setNombre(product.getNombre());
		carrito.setPrecio(product.getPrecio());
		
		
		carritoService.agregarCarrito(carrito);
		
		
		return "redirect:/carrito/listar";
	}
	
	
	@RequestMapping("/listarProductos")
	public String listarProducto(Model model) {
		
		model.addAttribute("lista_producto", productoService.listarProducto());
		return "/Carrito/reserva.jsp";
	}
	
	@RequestMapping("/quitar/{id}")
	public String quitarProducto(@PathVariable("id") Long id) {
		
		carritoService.quitarProducto(id);
		return "redirect:/carrito/listar";
	}
	
	
	
	
}

package com.everis.sumativa2.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa2.models.Categoria;
import com.everis.sumativa2.models.Producto;
import com.everis.sumativa2.services.CategoriaService;
import com.everis.sumativa2.services.ProductoService;



@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/listar")
	public String listarProducto(Model model, HttpSession session) {
		
		model.addAttribute("lista_producto", productoService.listarProducto());
		return "/Producto/listaProducto.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("nombre") String nombre,
			@RequestParam("precio") String precio,
			@RequestParam("caracteristica") String caracteristica,
			@RequestParam("categoria") List<Categoria> categoria,HttpSession session
			) {
		Producto producto = new Producto();
		
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setCaracteristicas(caracteristica);
		producto.setCategorias(categoria);
		
		
		producto = productoService.ingresarProducto(producto);
		
		return "redirect:/producto/listar";
	}
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Producto producto= productoService.buscarProducto(id);
		
		List<Categoria> lista_categoria =  categoriaService.listarCategoria();
		
		model.addAttribute("producto", producto);
		model.addAttribute("lista_categoria", lista_categoria);
		return "/Producto/editarProducto.jsp";
	}
	
	@RequestMapping("/actualizar")
	public String actualizarProducto(@ModelAttribute("producto")Producto producto ) {
		productoService.ingresarProducto(producto);
		return "redirect:/producto/listar";
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Long id ) {
		productoService.eliminarProducto(id);
		return "redirect:/producto/listar";
	}
	
}

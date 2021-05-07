package com.everis.sumativa2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa2.models.Categoria;
import com.everis.sumativa2.models.User;
import com.everis.sumativa2.services.CategoriaService;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/listar")
	public String listarCategoria(Model model) {
		
		List<Categoria> lista_categoria=categoriaService.listarCategoria();
		model.addAttribute("lista_categoria",lista_categoria );
		return "/Categoria/listaCategoria.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresarCategoria(@RequestParam("nombre") String nombre) {
		System.out.println("estoy en ingresar ");
		Categoria cat = new Categoria();
		
		cat.setNombre(nombre);
		
		 categoriaService.ingresarCategoria(cat);
		
		return "redirect:/categoria/listar";
		
	}
	
}

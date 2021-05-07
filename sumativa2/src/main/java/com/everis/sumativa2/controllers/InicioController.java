package com.everis.sumativa2.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.sumativa2.models.User;
import com.everis.sumativa2.services.CategoriaService;

@Controller
public class InicioController {
	@Autowired
	CategoriaService categoriaService;
	
	
	
	@RequestMapping("/")
	public String index(@Valid @ModelAttribute("user") User user,HttpSession session, Model model) {
		
		model.addAttribute("user",new User());
		
		//session.invalidate();
		session.setAttribute("registrado",0);
		return "login.jsp";
	}
	
	@RequestMapping("/login")
	public String index2(@Valid @ModelAttribute("user") User user,HttpSession session, Model model) {
		
		model.addAttribute("user",new User());
		
		//session.invalidate();
		session.setAttribute("registrado",0);
		return "login.jsp";
	}
	
	/*
	@GetMapping("/login")
	public String getLogin(HttpSession session) {
		session.setAttribute("registrado",0);
		return "login.jsp";
	}	*/
	
	@RequestMapping("/registro")
	public String registro(@Valid @ModelAttribute("user") User user,Model model,HttpSession session) {
		model.addAttribute("user", new User());
		System.out.println("Registro");
//diferenciar segun rol
//existencia de usuario por email
//validar contraseñas
		

		
		return "registro.jsp";
	}
	
	@RequestMapping("/index")
			public String index() {
	
		return "index.jsp";
	}
	
	@RequestMapping("/ingUser")
	public String formUser(HttpSession session) {
		
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		
		return "ingresoUser.jsp";
			
		}else {
		
			return "redirect:/login";
		
		}
		
	}
	
	@RequestMapping("/ingProducto")
	public String formProducto(Model model, HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		
		model.addAttribute("lista_categoria",categoriaService.listarCategoria());
		
		return "/Producto/ingresoProducto.jsp";
		
			
		}else {
			return "redirect:/login";
			
		}
		
	}
	
	@RequestMapping("/ingCategoria")
	public String formCategoria(HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		
		
		return "/Categoria/ingresoCategoria.jsp";
		
			
		}else {
			return "redirect:/login";
			
		}
		
	}
}

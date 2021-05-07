package com.everis.sumativa2.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.everis.sumativa2.models.User;
import com.everis.sumativa2.services.ProductoService;
import com.everis.sumativa2.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("user") User user,HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		System.out.println("persona - guardar");
		user= userService.guardarUser(user);
		
			
		}
		return "redirect:/login";
	}
	
	
	@RequestMapping("/ingreso")
	public String ingresarUser(@RequestParam("usuario") String usuario,@RequestParam("pass")String pass,@RequestParam("rol")String rol,
			@RequestParam("email")String email,Model model) {
		User user = new User();
		
		user.setUsuario(usuario);
		user.setPass(pass);
		user.setRol(rol);
		user.setEmail(email);
		user = userService.ingresoUser(user);
		
		return "redirect:/user/listar";
	}
	
	@RequestMapping("/listar")
	public String listarUsuarios( Model model) {
		List<User> lista_usuario=userService.listarUser();
		model.addAttribute("lista_usuario",lista_usuario);
		return "listaUser.jsp";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarUsuarios(@PathVariable("id") Long id) {
		
		userService.eliminarUser(id);
		
		return "redirect:/user/listar";
	}
	
	@RequestMapping("/editar/{id}")
	public String actualizarFormUsuarios(@PathVariable("id") Long id,Model model) {
		
		Optional<User> user = userService.buscarUser(id);
		model.addAttribute("user", user);
		
		return "editarUser.jsp";
	}
	
	@RequestMapping("/actualizar")
	public String actualizarUsuarios(@Valid @ModelAttribute("user") User user) {
				
		user = userService.actualizarUser(user);

		return "redirect:/user/listar";
		
	}
	
	
	
	@PostMapping("/login")
	public String loginInicial(@Valid @ModelAttribute("user") User user,
			HttpSession session,
			Model model) {
		
		String email = user.getEmail();
		String password = user.getPass();
		System.out.println("user - login");
		//boolean respuesta = pService.autenticacion(email, password);
		
		
		if(userService.autenticacion(email, password)) { 
			session.setAttribute("email", email);
			session.setAttribute("registrado",1);//boolean
			session.setAttribute("contador",100);
			//User usuario = userService.buscarRol(email);
			
			//session.setAttribute("rol", usuario.getRoles());
			//System.out.println("el rol del usuario "+email+" es : "+usuario.getRoles());
			
			String mail = (String) session.getAttribute("email");
			Integer registrado = (Integer) session.getAttribute("registrado");
			Integer contador = (Integer) session.getAttribute("contador");
		
			System.out.println(mail+" - "+registrado+" - "+contador);
			
			//model.addAttribute("registrado", true);
			return "index.jsp";
			
		}else {
			session.removeAttribute("registrado");
			session.setAttribute("registrado",0);
			//session.invalidate();
			model.addAttribute("mensaje", "Datos erroneos");
			return "login.jsp";
		}
		
	}
	


	
}

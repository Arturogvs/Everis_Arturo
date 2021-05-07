package com.everis.sumativa2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa2.models.Categoria;
import com.everis.sumativa2.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	public void ingresarCategoria(Categoria cat) {
		// TODO Auto-generated method stub
		System.out.println("estoy en categoriaservice"+cat.getNombre());
		categoriaRepository.save(cat);
	}

}

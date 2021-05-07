package com.everis.sumativa2.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String precio;
	private String caracteristicas;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //mucho a mucho
    @ManyToMany(fetch=FetchType.LAZY)
  //tabla relacional
    @JoinTable(
    		name = "categorias_productos",
    	joinColumns = @JoinColumn(name= "producto_id"),
    	inverseJoinColumns = @JoinColumn(name= "categoria_id")
    		)
    private List<Categoria> categorias;

	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, String precio, String caracteristicas, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.caracteristicas = caracteristicas;
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categoria) {
		this.categorias = categoria;
	}

    
}

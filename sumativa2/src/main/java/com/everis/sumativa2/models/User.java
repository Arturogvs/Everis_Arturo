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
@Table(name="users")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String usuario;
	
		private String pass;
		
		private String email;
		
		private String rol; 
		
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;

	    //mucho a mucho
	    @ManyToMany(fetch=FetchType.LAZY)
	  //tabla relacional
	    @JoinTable(
	    		name="users_roles", //plural
	    	joinColumns = @JoinColumn(name= "user_id"),//singular
	    	inverseJoinColumns = @JoinColumn(name= "rol_id")//singular
	    		)
	    private List<Rol> roles;
	    
	  
	    
	    
		public User() {
			super();
		}

	
		
		

		public User(Long id, String usuario, String pass, String email, String rol) {
			super();
			this.id = id;
			this.usuario = usuario;
			this.pass = pass;
			this.email = email;
			this.rol = rol;
		}





		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}





		public List<Rol> getRoles() {
			return roles;
		}





		public void setRoles(List<Rol> roles) {
			this.roles = roles;
		}
		
		
	
}

package com.diegoasmat.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull
	@Size(min=5,max=200, message = "El titlo debe tener al menos 5 caracteres")
	private String title;
	
	@NotNull
	@Size(min=5,max=200,message = "La descripción es muy corta.")
	private String description;
	
	@NotNull
	@Size(min = 3,max = 40, message="El lenguaje debe tener al menos 3 caracteres.")
	private String language;
	
	@NotNull
	@Min(value=100, message="Debe tener al menos 100 páginas.")
	private Integer numOfPages;
	
	//No permite cambios después de la creación
	@Column(updatable = false)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date updatedAt;
	
	public Libro() {
		
	}

	
	public Libro(String title, String description, String language, Integer numOfPages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numOfPages = numOfPages;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(Integer numOfPages) {
		this.numOfPages = numOfPages;
	}
	
	@PrePersist //Ejecuta antes de crear el objeto
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate //Ejecuta cuando hay modificaciones
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	
}

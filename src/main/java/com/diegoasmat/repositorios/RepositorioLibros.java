package com.diegoasmat.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegoasmat.modelos.Libro;

@Repository
public interface RepositorioLibros extends CrudRepository<Libro, Long> {
	
	List<Libro> findAll(); 
	
	List<Libro> findByDescriptionContaining(String search);
	
	
	Long countByTitleContaining(String search);
	
	Long deleteByTitleStartingWith(String search);
	
	
}

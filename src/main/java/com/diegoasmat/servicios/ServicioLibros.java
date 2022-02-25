package com.diegoasmat.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diegoasmat.modelos.Libro;
import com.diegoasmat.repositorios.RepositorioLibros;

@Service
public class ServicioLibros {

	private final RepositorioLibros repositorioLibros;
	
	public ServicioLibros(RepositorioLibros repositorioLibros) {
		this.repositorioLibros = repositorioLibros;
	}
	
	public List<Libro> allBooks(){
		return repositorioLibros.findAll();
	}
	
	public Libro createBook(Libro libro) {
		return repositorioLibros.save(libro);
	}
	
	public Libro findBook(Long id) {
		Optional<Libro> optionalBook = repositorioLibros.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	public Libro updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Libro libro = findBook(id);
		if(libro!=null) {
			libro.setTitle(title);
			libro.setDescription(desc);
			libro.setLanguage(lang);
			libro.setNumOfPages(numOfPages);
			
			return repositorioLibros.save(libro);
		}
		
		return null;
	}
	
	public void deleteBook(Long id) {
		repositorioLibros.deleteById(id);
	}
}

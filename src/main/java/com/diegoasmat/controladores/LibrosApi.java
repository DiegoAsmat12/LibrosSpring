package com.diegoasmat.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diegoasmat.modelos.Libro;
import com.diegoasmat.servicios.ServicioLibros;

@RestController
public class LibrosApi {
	private final ServicioLibros servicioLibros;
	
	public LibrosApi(ServicioLibros servicioLibros) {
		this.servicioLibros = servicioLibros;
	}
	
	@GetMapping("/api/books")
	public List<Libro> index(){
		return servicioLibros.allBooks();
	}
	
	@GetMapping("/api/books/{id}")
	public Libro show(@PathVariable("id") Long id) {
		Libro libro = servicioLibros.findBook(id);
		return libro;
	}
	
	@RequestMapping(value="/api/books", method = RequestMethod.POST)
	public Libro create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang, @RequestParam(value="pages")Integer numOfPages) {
		Libro libro = new Libro(title,desc,lang,numOfPages);
		return servicioLibros.createBook(libro);
	}
	
	@RequestMapping(value="/api/books/{id}", method = RequestMethod.PUT)
	public Libro update(@PathVariable("id") Long id, @RequestParam(value="title") String title, 
			@RequestParam(value="description") String desc, @RequestParam(value="language") String lang,
			@RequestParam(value="pages") Integer numOfPages) {
		Libro libro = servicioLibros.updateBook(id, title, desc, lang, numOfPages);
		return libro;
		
	}
	
	@RequestMapping(value="/api/books/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		servicioLibros.deleteBook(id);
	}
}

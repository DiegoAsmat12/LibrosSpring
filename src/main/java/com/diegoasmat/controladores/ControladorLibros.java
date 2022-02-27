package com.diegoasmat.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegoasmat.modelos.Libro;
import com.diegoasmat.servicios.ServicioLibros;

@Controller
@RequestMapping("/books")
public class ControladorLibros {
	
	@Autowired
	private ServicioLibros servicioLibros;
	
	@GetMapping("/{id}")
	public String renderBook(Model model,@PathVariable("id") Long id) {
		Libro libro = servicioLibros.findBook(id);
		
		model.addAttribute("book", libro);
		
		return "libro.jsp";
	}
	
	@GetMapping("")
	public String index(Model model) {
		List<Libro> libros = servicioLibros.allBooks();
		model.addAttribute("books", libros);
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String renderBookForm(@ModelAttribute("book") Libro libro) {
		//@ModelAttribute es como cuando pasas el model.addAttr...
		// o model.addAttribute("book", new Libro());
		return "newBook.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("book") Libro libro, BindingResult result) { 
		//Binding result sirve para validar contra el modelo
		//Debemos agregar @Valid
		if(result.hasErrors()) {
			return "newBook.jsp";
		}

		servicioLibros.createBook(libro);
		
		return "redirect:/books";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Libro book = servicioLibros.findBook(id);
		model.addAttribute("book", book); 
		//usamos esto para pasar el libro que YA existe! de esa forma el programa ya tiene el id para editar posteriormente
		
		return "edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute("book") Libro book, BindingResult result) {
		//Podríamos usar modelAttribute para definir una variable COMO new Libro() en el get y en 
		//el post toma lo del formulario
		//PAra poder hacer update de todos los campos necesitamos TODOS los getters y setters!!
		if(result.hasErrors()) {
			return "/books/edit.jsp";
		}
		servicioLibros.updateLibro(book);
		return "redirect:/books";
		
	}
}

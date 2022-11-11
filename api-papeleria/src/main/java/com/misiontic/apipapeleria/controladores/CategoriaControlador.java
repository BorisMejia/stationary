package com.misiontic.apipapeleria.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.apipapeleria.entidades.Categoria;
import com.misiontic.apipapeleria.servicios.CategoriaServicio;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaControlador {
	
	@Autowired
	private CategoriaServicio cateServicio;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = "application/json")
	public Categoria crearCategoria(@RequestBody Categoria objCategoria) {
		cateServicio.agregar(objCategoria);
		return objCategoria;
	}
	
	@RequestMapping(value = "/todas", method = RequestMethod.GET)
	public List<Categoria> obtenerCategorias(){
		return cateServicio.obtenerTodos();
	}
	
	@ResponseStatus(code = HttpStatus.OK, reason = "Categoria eliminada correctamente.")
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
	public void borrarCategoria(@PathVariable Long id) {
		cateServicio.eliminar(id);
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Categoria actualizada correctamente.")
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
	public void actualizarCategoria(@RequestBody Categoria objCategoria) {
		cateServicio.actualizar(objCategoria);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/uno/{id}", method = RequestMethod.GET)
	public Categoria obtenerUnaCategoria(@PathVariable Long id) {
		return cateServicio.obtenerUno(id);
	}

}

package com.misiontic.apipapeleria.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.misiontic.apipapeleria.entidades.Producto;
import com.misiontic.apipapeleria.interfaces.Operaciones;
import com.misiontic.apipapeleria.repositorios.ProductoRepositorio;

@Service
public class ProductoServicio implements Operaciones<Producto> {
	
	@Autowired
	private ProductoRepositorio proRepo;
	
	@Override
	public boolean agregar(Producto objeto) {
		Producto objTemProducto = proRepo.save(objeto);
		return objTemProducto != null;
	}

	@Override
	public List<Producto> obtenerTodos() {
		return proRepo.findAll();
	}

	@Override
	public boolean eliminar(Long id) {
		proRepo.deleteById(id);
		return !proRepo.existsById(id);
	}

	@Override
	public boolean actualizar(Producto objeto) {
		Optional<Producto> objVerificado = proRepo.findById(objeto.getIdProducto());
		if(!objVerificado.isPresent()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Producto no existe");
		}else {
			proRepo.save(objeto);
			return true;
		}
	}

	@Override
	public Producto obtenerUno(Long id) {
		return proRepo.obtenerUno(id);
}
	}
	


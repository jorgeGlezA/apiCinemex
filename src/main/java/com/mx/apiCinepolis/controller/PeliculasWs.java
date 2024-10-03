package com.mx.apiCinepolis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiCinepolis.entity.Peliculas;
import com.mx.apiCinepolis.service.PeliculasImp;

@RestController
@RequestMapping("PeliculasWs")
@CrossOrigin
public class PeliculasWs {

	@Autowired
	PeliculasImp imp;

	// http://localhost:9000/PeliculasWs/listar
	@GetMapping("listar")
	public List<Peliculas> listar() {
		return imp.listar();
	}

	// http://localhost:9000/PeliculasWs/guardar
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula) {
		boolean response = imp.guardar(pelicula);

		if (response == true) {
			return new ResponseEntity<>("Ese registro ya existe, no se puede guardar", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
		}

	}

	// http://localhost:9000/PeliculasWs/buscar
	@PostMapping("buscar")
	public ResponseEntity<?> buscar(@RequestBody Peliculas pelicula) {
		if (imp.buscar(pelicula.getId())== null) {
			return new ResponseEntity<>("Ese registro no existe, ingrese otro ID", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(imp.buscar(pelicula.getId()), HttpStatus.CREATED);
		}
	}

	// http://localhost:9000/PeliculasWs/editar
	@PostMapping(path = "editar")
	public void editar(@RequestBody Peliculas pelicula) {
		imp.editar(pelicula);
	}

	// http://localhost:9000/PeliculasWs/eliminar
	@PostMapping(path = "eliminar")
	public void eliminar(@RequestBody Peliculas pelicula) {
		imp.eliminar(pelicula.getId());
	}

	// http://localhost:9000/PeliculasWs/buscarNombre
	@PostMapping("buscarNombre")
	public Peliculas buscarNombre(@RequestBody Peliculas pelicula) {
		return imp.buscarNombre(pelicula.getNombre());
	}

	// http://localhost:9000/PeliculasWs/buscarGenero
	@PostMapping("buscarGenero")
	public List<Peliculas> buscarGenero(@RequestBody Peliculas pelicula) {
		return imp.buscarGenero(pelicula.getGenero());
	}

	// http://localhost:9000/PeliculasWs/eliminarNombre
	@PostMapping("eliminarNombre")
	public void eliminarNombre(@RequestBody Peliculas pelicula) {
		imp.eliminarNombre(pelicula.getNombre());
	}
	
}

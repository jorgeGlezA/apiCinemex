package com.mx.apiCinepolis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.apiCinepolis.entity.Peliculas;
import com.mx.apiCinepolis.repository.PeliculasRepository;

import jakarta.transaction.Transactional;

@Service
public class PeliculasImp {

	@Autowired
	PeliculasRepository repositorio;

	public List<Peliculas> listar() {
		return (List<Peliculas>) repositorio.findAll(); // Casteo -- cambio de un tipo de valor por otro
	}

	public boolean guardar(Peliculas pelicula) {

		boolean bandera = false;
		for (Peliculas p : listar()) {
			if (p.getNombre().equals(pelicula.getNombre())) {
				bandera = true;
				break;
			}
		}

		if (bandera == false)
			repositorio.save(pelicula);

		return bandera;
	}

	// POST PARA BUSCAR POR ID

	public Peliculas buscar(Long idPeliculas) {

		return repositorio.findById(idPeliculas).orElse(null);
	}

	// POST EDITAR POR ID---- validar que el id exista

	public void editar(Peliculas pelicula) {
		repositorio.save(pelicula);
	}

	// POST PATA ELIMINAR ID ---- validar que el id exista
	public void eliminar(Long idPeliculas) {
		repositorio.deleteById(idPeliculas);
	}

	// POST PARA BUSCAR POR NOMBRE
	public Peliculas buscarNombre(String nombre) {

		return repositorio.findByNombre(nombre);
	}

	// POST PARA LISTAR POR GENERO
	public List<Peliculas> buscarGenero(String genero) {

		return repositorio.findByGenero(genero);
	}

	// POST PARA ELIMINAR POR NOMBRE
	@Transactional
	public void eliminarNombre(String nombre) {

		List<Peliculas> lista = (List<Peliculas>) repositorio.findAll();

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNombre().equals(nombre)) {
				repositorio.deleteById(lista.get(i).getId());
			}
		}

	}

}

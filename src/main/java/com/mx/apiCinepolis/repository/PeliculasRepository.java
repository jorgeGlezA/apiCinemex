package com.mx.apiCinepolis.repository;

import org.springframework.data.repository.CrudRepository;

import com.mx.apiCinepolis.entity.Peliculas;
import java.util.List;

public interface PeliculasRepository extends CrudRepository<Peliculas, Long> {

	public Peliculas findByNombre(String nombre);

	public List<Peliculas> findByGenero(String genero);

}

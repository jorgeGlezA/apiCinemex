package com.mx.apiCinepolis.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 CREATE TABLE PELICULAS_CI(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2 (100) NOT NULL,
FECHA_LANZ VARCHAR2 (150),
GENERO VARCHAR2 (80) NOT NULL,
PRECIO NUMBER 
);
 */

// SERIALIZACIÓN: Desintegración en bytes del estado de un objeto
// Deserialización: Reconstruccion del estado del objeto a partir de bytes

@Entity
@Table(name = "PELICULAS_CI")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Peliculas implements Serializable {

	private static final long serialVersionUID = 1L;
	// Controlar versiones de java para no perder información de bytes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "FECHA_LANZ")
	private Date fechaLanz;

	@Column(name = "GENERO")
	private String genero;

	@Column(name = "PRECIO")
	private Float precio;

}

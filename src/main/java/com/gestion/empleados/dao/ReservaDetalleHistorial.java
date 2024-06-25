package com.gestion.empleados.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;

@Table(name = "ReservaDetalle")
public class ReservaDetalleHistorial {

	@Id
	private Long id;
	private Integer id_reserva;
	private String nombreped;
	private String categoria;
	private String nombrec;
	private BigDecimal precio;

	//Constructor
	public ReservaDetalleHistorial(Long id, Integer id_reserva, String nombreped, String categoria, String nombrec, BigDecimal precio) {
		this.id = id;
		this.id_reserva = id_reserva;
		this.nombreped = nombreped;
		this.categoria = categoria;
		this.nombrec = nombrec;
		this.precio = precio;
	}

	//Getter y Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getNombreped() {
		return nombreped;
	}

	public void setNombreped(String nombreped) {
		this.nombreped = nombreped;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombrec() {
		return nombrec;
	}

	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}



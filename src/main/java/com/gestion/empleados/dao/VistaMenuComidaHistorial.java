package com.gestion.empleados.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Table("Vista_Menu_Comida_Historial")
public class VistaMenuComidaHistorial {
	@Id
	private Long id;
	private Long menuid;
	private String nombremenu;
	private String nombrecomida;
	private Double precio;
	private String categoria;
	private LocalDateTime fechaCambio;

	public VistaMenuComidaHistorial(Long menuid, String nombremenu, String nombrecomida, Double precio, String categoria, LocalDateTime fechaCambio) {
		this.menuid = menuid;
		this.nombremenu = nombremenu;
		this.nombrecomida = nombrecomida;
		this.precio = precio;
		this.categoria = categoria;
		this.fechaCambio = fechaCambio;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public String getNombremenu() {
		return nombremenu;
	}

	public void setNombremenu(String nombremenu) {
		this.nombremenu = nombremenu;
	}

	public String getNombrecomida() {
		return nombrecomida;
	}

	public void setNombrecomida(String nombrecomida) {
		this.nombrecomida = nombrecomida;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(LocalDateTime fechaCambio) {
		this.fechaCambio = fechaCambio;
	}
}

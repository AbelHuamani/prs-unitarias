package com.gestion.empleados.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("Vista_Menu_Comida")
public class VistaMenuComida {
    @Id
    private Long menuid;
    private String nombremenu;
    private String nombrecomida;
    private Double precio;
    private String categoria;
    
	public VistaMenuComida(Long menuid, String nombremenu, String nombrecomida, Double precio, String categoria) {
		this.menuid = menuid;
		this.nombremenu = nombremenu;
		this.nombrecomida = nombrecomida;
		this.precio = precio;
		this.categoria = categoria;
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
	
}

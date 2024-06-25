package com.gestion.empleados.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Comidas")
public class Comidas {
    @Id
    private Long comidaid;
    private String nombrec;
    private String categoria;
    private Double precio;
    private Long menuid;
    private String estado;
    
	public Long getComidaid() {
		return comidaid;
	}
	
	public void setComidaid(Long comidaid) {
		this.comidaid = comidaid;
	}
	public String getNombrec() {
		return nombrec;
	}
	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    
    
	
}


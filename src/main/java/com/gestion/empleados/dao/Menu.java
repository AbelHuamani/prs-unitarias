package com.gestion.empleados.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Menus")
public class Menu {
    @Id
    private Long menuid;
    private String nombrem;
    private String estado;
    
	public Menu(Long menuid, String nombrem, String estado) {
		this.menuid = menuid;
		this.nombrem = nombrem;
		this.estado = estado;
	}
	
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public String getNombrem() {
		return nombrem;
	}
	public void setNombrem(String nombrem) {
		this.nombrem = nombrem;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
    
	
}

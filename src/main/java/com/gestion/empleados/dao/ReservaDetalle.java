package com.gestion.empleados.dao;

import java.math.BigDecimal;
import java.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "RESERVA")
public class ReservaDetalle {
	@Id
    private Long id_reserva;
	private String nombreu;
    private String correo;
    private LocalTime hora_reserva;
    private int num_personas;
	private BigDecimal montoTotal;

	public ReservaDetalle(Long id_reserva, String nombreu, String correo, LocalTime hora_reserva, int num_personas, BigDecimal montoTotal) {
		this.id_reserva = id_reserva;
		this.nombreu = nombreu;
		this.correo = correo;
		this.hora_reserva = hora_reserva;
		this.num_personas = num_personas;
		this.montoTotal = montoTotal;
	}

	public Long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getNombreu() {
		return nombreu;
	}

	public void setNombreu(String nombreu) {
		this.nombreu = nombreu;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalTime getHora_reserva() {
		return hora_reserva;
	}

	public void setHora_reserva(LocalTime hora_reserva) {
		this.hora_reserva = hora_reserva;
	}

	public int getNum_personas() {
		return num_personas;
	}

	public void setNum_personas(int num_personas) {
		this.num_personas = num_personas;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}
}

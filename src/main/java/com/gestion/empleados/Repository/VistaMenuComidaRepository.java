package com.gestion.empleados.Repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.gestion.empleados.dao.VistaMenuComida;

import reactor.core.publisher.Flux;

public interface VistaMenuComidaRepository extends ReactiveCrudRepository<VistaMenuComida, Long> {
	@Query("SELECT * FROM Vista_Menu_Comida WHERE nombremenu = :nombreMenu")
    Flux<VistaMenuComida> findByNombreMenu(String nombreMenu);
}


package com.gestion.empleados.Repository;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.gestion.empleados.dao.Comidas;

import reactor.core.publisher.Flux;


public interface ComidaRepository extends ReactiveCrudRepository<Comidas, Long> {
	 @Query("SELECT * FROM Comidas WHERE estado IN ('A', 'I')")
	    Flux<Comidas> findAllNotDeleted();

	    @Query("SELECT * FROM Comidas WHERE estado = :estado")
	    Flux<Comidas> findByEstado(@Param("estado") String estado);
}
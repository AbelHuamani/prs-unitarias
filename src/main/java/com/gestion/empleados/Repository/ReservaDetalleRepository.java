package com.gestion.empleados.Repository;


import com.gestion.empleados.dao.ReservaDetalle;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ReservaDetalleRepository extends ReactiveCrudRepository<ReservaDetalle, Long> {
	
}

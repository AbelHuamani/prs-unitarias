package com.gestion.empleados.Repository;

import com.gestion.empleados.dao.ReservaDetalleHistorial;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ReservaDetalleHistorialRepository extends ReactiveCrudRepository<ReservaDetalleHistorial, Long> {

}

package com.gestion.empleados.Repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.gestion.empleados.dao.VistaMenuComidaHistorial;
import reactor.core.publisher.Flux;

public interface VistaMenuComidaHistorialRepository extends ReactiveCrudRepository<VistaMenuComidaHistorial, Long> {
    @Query("SELECT menuid, nombremenu, nombrecomida, precio, categoria, CURRENT_TIMESTAMP\n" +
            "FROM Vista_Menu_Comida;")
    Flux<VistaMenuComidaHistorial> findByMenuId(Long menuId);
}


package com.gestion.empleados.Repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.gestion.empleados.dao.Menu;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuRepository extends ReactiveCrudRepository<Menu, Long> {
	@Query("SELECT * FROM Menus WHERE estado IN ('A', 'I')")
    Flux<Menu> findAllNotDeleted();

    @Query("SELECT * FROM Menus WHERE estado = :estado")
    Flux<Menu> findByEstado(@Param("estado") String estado);
    
    Mono<Menu> findByMenuid(Long  menuid);
}


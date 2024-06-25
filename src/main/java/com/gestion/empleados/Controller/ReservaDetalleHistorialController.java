package com.gestion.empleados.Controller;

import com.gestion.empleados.Repository.ReservaDetalleRepository;
import com.gestion.empleados.dao.ReservaDetalle;
import com.gestion.empleados.dao.ReservaDetalleHistorial;
import com.gestion.empleados.Repository.ReservaDetalleHistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/reservaDetalleHistorial")
public class ReservaDetalleHistorialController {
    private final ReservaDetalleHistorialRepository reservaDetalleHistorialRepository;

    @Autowired
    public ReservaDetalleHistorialController(ReservaDetalleHistorialRepository reservaDetalleHistorialRepository) {
        this.reservaDetalleHistorialRepository = reservaDetalleHistorialRepository;
    }

    @GetMapping("/findAll")
    public Flux<ReservaDetalleHistorial> getAllReservaDetallesHistorial() {
        return reservaDetalleHistorialRepository.findAll();
    }

}


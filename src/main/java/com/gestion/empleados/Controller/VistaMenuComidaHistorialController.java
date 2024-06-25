package com.gestion.empleados.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestion.empleados.Repository.VistaMenuComidaHistorialRepository;
import com.gestion.empleados.dao.VistaMenuComidaHistorial;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/vista-menu-comida-historial")
public class VistaMenuComidaHistorialController {

    private final VistaMenuComidaHistorialRepository vistaMenuComidaHistorialRepository;

    @Autowired
    public VistaMenuComidaHistorialController(VistaMenuComidaHistorialRepository vistaMenuComidaHistorialRepository) {
        this.vistaMenuComidaHistorialRepository = vistaMenuComidaHistorialRepository;
    }

    @GetMapping
    public Flux<VistaMenuComidaHistorial> getAllHistorial() {
        return vistaMenuComidaHistorialRepository.findAll();
    }

    @GetMapping("/{menuId}")
    public Flux<VistaMenuComidaHistorial> getHistorialByMenuId(@PathVariable Long menuId) {
        return vistaMenuComidaHistorialRepository.findByMenuId(menuId);
    }
}

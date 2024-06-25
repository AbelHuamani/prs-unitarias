package com.gestion.empleados.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestion.empleados.Repository.VistaMenuComidaRepository;
import com.gestion.empleados.dao.VistaMenuComida;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/vista-menu-comida")
public class VistaMenuComidaController {

    private final VistaMenuComidaRepository vistaMenuComidaRepository;

    @Autowired
    public VistaMenuComidaController(VistaMenuComidaRepository vistaMenuComidaRepository) {
        this.vistaMenuComidaRepository = vistaMenuComidaRepository;
    }

    @GetMapping("/{nombreMenu}")
    public Flux<VistaMenuComida> getComidasPorMenu(@PathVariable String nombreMenu) {
        return vistaMenuComidaRepository.findByNombreMenu(nombreMenu);
    }
    
    @GetMapping
    public Flux<VistaMenuComida> getAllVistaMenuComida() {
        return vistaMenuComidaRepository.findAll();
    }

}

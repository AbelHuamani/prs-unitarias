package com.gestion.empleados.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestion.empleados.Repository.ComidaRepository;
import com.gestion.empleados.dao.Comidas;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
//gpt
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/comida")
public class ComidaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComidaController.class);

    @Autowired
    private ComidaRepository comidaRepository;
    
    @Autowired
  //  private MenuRepository menuRepository;
    
    @GetMapping("/findAll")
    public Flux<Comidas> getAllComida() {
        return comidaRepository.findAllNotDeleted();
    } 
    /*@GetMapping("/findAll")
    public Flux<Comidas> getAllComida() {
        return comidaRepository.findAllNotDeleted()
                .flatMap(comida ->
                        menuRepository.findByMenuid(comida.getMenuid())
                                .map(menu -> {
                                    comida.setNombremenu(menu.getNombre());
                                    return comida;
                                }).defaultIfEmpty(comida)
                );
    }*/
    @GetMapping("/findByEstado/{estado}")
    public Flux<Comidas> getComidaByEstado(@PathVariable String estado) {
        return comidaRepository.findByEstado(estado);
    }

    @GetMapping("/{id}")
    public Mono<Comidas> getComidaById(@PathVariable Long id) {
        return comidaRepository.findById(id);
    }

    @PostMapping
    public Mono<Comidas> insertComida(@RequestBody Comidas comida) {
        return comidaRepository.save(comida);
    }

    @PutMapping("/{id}/eliminar")
    public Mono<Comidas> eliminarComidaById(@PathVariable Long id) {
        return comidaRepository.findById(id)
                .flatMap(c -> {
                    c.setEstado("I");
                    LOGGER.info("Eliminando lógicamente comida con id: {}", id);
                    return comidaRepository.save(c);
                });
    }

    @PutMapping("/{id}/restaurar")
    public Mono<Comidas> restaurarComidaById(@PathVariable Long id) {
        return comidaRepository.findById(id)
                .flatMap(c -> {
                    c.setEstado("A");
                    LOGGER.info("Restaurando lógicamente comida con id: {}", id);
                    return comidaRepository.save(c);
                });
    }

    @PutMapping("/{id}")
    public Mono<Comidas> updateComidaById(@RequestBody Comidas comida, @PathVariable Long id) {
        return comidaRepository.findById(id)
                .flatMap(c -> {
                    c.setNombrec(comida.getNombrec());
                    c.setCategoria(comida.getCategoria());
                    c.setPrecio(comida.getPrecio());
                    c.setEstado(comida.getEstado());
                    c.setMenuid(comida.getMenuid()); // You may need to handle menuid update
                    return comidaRepository.save(c);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return comidaRepository.deleteById(id);
    }
}
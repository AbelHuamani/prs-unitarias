package com.gestion.empleados.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestion.empleados.Repository.MenuRepository;
import com.gestion.empleados.dao.Menu;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/menus")
public class MenuController {

	@Autowired
    private MenuRepository menuRepository;

    @GetMapping("/findAll")
    public Flux<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    @GetMapping("/findAllNotDeleted")
    public Flux<Menu> getAllMenuNotDeleted() {
        return menuRepository.findAllNotDeleted();
    }

    @GetMapping("/findByEstado/{estado}")
    public Flux<Menu> getMenuByEstado(@PathVariable String estado) {
        return menuRepository.findByEstado(estado);
    }

    @GetMapping("/{id}")
    public Mono<Menu> getMenuById(@PathVariable Long id) {
        return menuRepository.findById(id);
    }

    @PostMapping
    public Mono<Menu> insertMenu(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    @PutMapping("/{id}/eliminar")
    public Mono<Menu> eliminarMenuById(@PathVariable Long id) {
        return menuRepository.findById(id)
                .flatMap(m -> {
                    m.setEstado("I");
                    return menuRepository.save(m);
                });
    }

    @PutMapping("/{id}/restaurar")
    public Mono<Menu> restaurarMenuById(@PathVariable Long id) {
        return menuRepository.findById(id)
                .flatMap(m -> {
                    m.setEstado("A");
                    return menuRepository.save(m);
                });
    }

    @PutMapping("/{id}")
    public Mono<Menu> updateMenuById(@RequestBody Menu menu, @PathVariable Long id) {
        return menuRepository.findById(id)
                .flatMap(m -> {
                    m.setNombrem(menu.getNombrem());
                    m.setEstado(menu.getEstado());
                    return menuRepository.save(m);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return menuRepository.deleteById(id);
    }
}
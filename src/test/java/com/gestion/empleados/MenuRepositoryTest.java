package com.gestion.empleados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.gestion.empleados.Controller.MenuController;
import com.gestion.empleados.Repository.MenuRepository;
import com.gestion.empleados.dao.Menu;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MenuRepositoryTest {

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuController menuController;

    private Menu menu1;
    private Menu menu2;

    @BeforeEach
    void setUp() {
        menu1 = new Menu(1L, "Menu 1", "A");
        menu2 = new Menu(2L, "Menu 2", "I");
    }

    @Test
    void getAllMenu() {
        when(menuRepository.findAll()).thenReturn(Flux.just(menu1, menu2));

        StepVerifier.create(menuController.getAllMenu())
                .expectNext(menu1)
                .expectNext(menu2)
                .verifyComplete();
    }

    @Test
    void getAllMenuNotDeleted() {
        when(menuRepository.findAllNotDeleted()).thenReturn(Flux.just(menu1));

        StepVerifier.create(menuController.getAllMenuNotDeleted())
                .expectNext(menu1)
                .verifyComplete();
    }

    @Test
    void getMenuByEstado() {
        when(menuRepository.findByEstado("A")).thenReturn(Flux.just(menu1));

        StepVerifier.create(menuController.getMenuByEstado("A"))
                .expectNext(menu1)
                .verifyComplete();
    }

    @Test
    void getMenuById() {
        when(menuRepository.findById(1L)).thenReturn(Mono.just(menu1));

        StepVerifier.create(menuController.getMenuById(1L))
                .expectNext(menu1)
                .verifyComplete();
    }

    @Test
    void insertMenu() {
        Menu newMenu = new Menu(3L, "New Menu", "A");
        when(menuRepository.save(any(Menu.class))).thenReturn(Mono.just(newMenu));

        StepVerifier.create(menuController.insertMenu(newMenu))
                .expectNext(newMenu)
                .verifyComplete();
    }

    @Test
    void eliminarMenuById() {
        Menu updatedMenu = new Menu(1L, "Menu 1", "I");
        when(menuRepository.findById(1L)).thenReturn(Mono.just(menu1));
        when(menuRepository.save(any(Menu.class))).thenReturn(Mono.just(updatedMenu));

        StepVerifier.create(menuController.eliminarMenuById(1L))
                .expectNext(updatedMenu)
                .verifyComplete();
    }

    @Test
    void restaurarMenuById() {
        Menu updatedMenu = new Menu(2L, "Menu 2", "A");
        when(menuRepository.findById(2L)).thenReturn(Mono.just(menu2));
        when(menuRepository.save(any(Menu.class))).thenReturn(Mono.just(updatedMenu));

        StepVerifier.create(menuController.restaurarMenuById(2L))
                .expectNext(updatedMenu)
                .verifyComplete();
    }

    @Test
    void updateMenuById() {
        Menu updatedMenu = new Menu(1L, "Updated Menu", "A");
        when(menuRepository.findById(1L)).thenReturn(Mono.just(menu1));
        when(menuRepository.save(any(Menu.class))).thenReturn(Mono.just(updatedMenu));

        StepVerifier.create(menuController.updateMenuById(updatedMenu, 1L))
                .expectNext(updatedMenu)
                .verifyComplete();
    }
}
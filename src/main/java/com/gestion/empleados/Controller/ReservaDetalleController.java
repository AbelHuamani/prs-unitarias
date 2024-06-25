package com.gestion.empleados.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.Repository.ReservaDetalleRepository;
import com.gestion.empleados.dao.ReservaDetalle;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservaDetalle")
public class ReservaDetalleController {

    private final ReservaDetalleRepository reservaDetalleRepository;
    private final JavaMailSender mailSender;

    @Autowired
    public ReservaDetalleController(ReservaDetalleRepository reservaDetalleRepository, JavaMailSender mailSender) {
        this.reservaDetalleRepository = reservaDetalleRepository;
        this.mailSender = mailSender;
    }

    @GetMapping("/findAll")
    public Flux<ReservaDetalle> getAllReservaDetalle() {
        return reservaDetalleRepository.findAll();
    }

    @PostMapping("/add")
    public Mono<ReservaDetalle> createReservaDetalle(@RequestBody ReservaDetalle reservaDetalle) {
        return reservaDetalleRepository.save(reservaDetalle)
                .doOnSuccess(this::sendReservaConfirmationMail);
    }

  /*  @PutMapping("/update/{id}")
    public Mono<ReservaDetalle> updateReservaDetalle(@PathVariable Long id,
            @RequestBody ReservaDetalle reservaDetalle) {
        return reservaDetalleRepository.findById(id)
                .flatMap(existingReservaDetalle -> {
                	existingReservaDetalle.setNombreu(reservaDetalle.getNombreu());
                    existingReservaDetalle.setCorreo(reservaDetalle.getCorreo());
                    existingReservaDetalle.setHora_reserva(reservaDetalle.getHora_reserva());
                    existingReservaDetalle.setNum_personas(reservaDetalle.getNum_personas());
                    return reservaDetalleRepository.save(existingReservaDetalle);
                })
                .switchIfEmpty(Mono.empty());
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteReservaDetalle(@PathVariable Long id) {
        return reservaDetalleRepository.deleteById(id);
    } */

    private void sendReservaConfirmationMail(ReservaDetalle reserva) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-gmail-username@gmail.com");
        message.setTo(reserva.getCorreo());
        message.setSubject("Reserva Exitosa");
        message.setText("Estimado " + reserva.getNombreu() + " su reserva ha sido confirmada para la hora de " + reserva.getHora_reserva() + 
                         " para: " + reserva.getNum_personas() + " personas.");
        mailSender.send(message);
    }
}

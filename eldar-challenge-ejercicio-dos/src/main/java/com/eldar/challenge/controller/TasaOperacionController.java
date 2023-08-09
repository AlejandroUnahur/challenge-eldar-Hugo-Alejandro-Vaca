package com.eldar.challenge.controller;

import com.eldar.challenge.entity.TasaOperacion;
import com.eldar.challenge.service.TasaOperacionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasaOperaciones")
public class TasaOperacionController {
    private TasaOperacionService tasaOperacionService;
    public TasaOperacionController(TasaOperacionService tasaOperacionService) {this.tasaOperacionService = tasaOperacionService;}
    @PostMapping()
    public ResponseEntity<TasaOperacion> createTasaOperacion(@RequestBody TasaOperacion tasaOperacion) {
      TasaOperacion tasaOperacionCreated = this.tasaOperacionService.createTasaOperacion(tasaOperacion);
      return ResponseEntity.status(HttpStatus.CREATED).body(tasaOperacionCreated);
    }
    @GetMapping()
    public ResponseEntity<List<TasaOperacion>> getAllTasaOperacion() {
        List<TasaOperacion> tasaOperaciones = this.tasaOperacionService.getAllTasaOperacion();
        return ResponseEntity.ok().body(tasaOperaciones);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TasaOperacion>> getTasaOperacionById(@PathVariable UUID id) {
        Optional<TasaOperacion> tasaOperacion;
        try {
            tasaOperacion = this.tasaOperacionService.getTasaOperacionById(id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(tasaOperacion);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TasaOperacion> updateTasaOperacion(@PathVariable UUID id ,@RequestBody TasaOperacion tasaOperacion) {
        TasaOperacion result = this.tasaOperacionService.updateTasaOperacion(id,tasaOperacion);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTasaOperacion(@PathVariable UUID id) {
        try {
            this.tasaOperacionService.deleteTasaOperacion(id);
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

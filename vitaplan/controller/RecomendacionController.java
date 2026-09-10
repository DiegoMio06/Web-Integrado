/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.vitaplan.controller;

import com.example.vitaplan.model.Recomendacion;
import com.example.vitaplan.repository.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/recomendaciones")
public class RecomendacionController {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @GetMapping
    public List<Recomendacion> obtenerTodas() {
        return recomendacionRepository.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Recomendacion> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return recomendacionRepository.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public Recomendacion crearRecomendacion(@RequestBody Recomendacion recomendacion) {
        if (recomendacion.getFechaGeneracion() == null) {
            recomendacion.setFechaGeneracion(LocalDateTime.now());
        }
        return recomendacionRepository.save(recomendacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecomendacion(@PathVariable Long id) {
        if (recomendacionRepository.existsById(id)) {
            recomendacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
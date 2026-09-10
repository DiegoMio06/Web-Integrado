/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.vitaplan.controller;

import com.example.vitaplan.model.Habito;
import com.example.vitaplan.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitos")
public class HabitoController {

    @Autowired
    private HabitoRepository habitoRepository;

    @GetMapping
    public List<Habito> obtenerTodos() {
        return habitoRepository.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Habito> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return habitoRepository.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public Habito crearHabito(@RequestBody Habito habito) {
        return habitoRepository.save(habito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habito> actualizarHabito(@PathVariable Long id, @RequestBody Habito detalles) {
        return habitoRepository.findById(id)
                .map(habito -> {
                    habito.setNombre(detalles.getNombre());
                    habito.setDescripcion(detalles.getDescripcion());
                    habito.setFrecuencia(detalles.getFrecuencia());
                    habito.setCompletado(detalles.isCompletado());
                    return ResponseEntity.ok(habitoRepository.save(habito));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabito(@PathVariable Long id) {
        if (habitoRepository.existsById(id)) {
            habitoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
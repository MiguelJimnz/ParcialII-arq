package com.example.parcialArq.controller;

import com.example.parcialArq.models.Entrenador;
import com.example.parcialArq.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenador")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> getAll() {
        return entrenadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getById(@PathVariable Integer id) {
        return entrenadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador create(@RequestBody Entrenador entrenador) {
        return entrenadorService.save(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(@PathVariable Integer id, @RequestBody Entrenador entrenador) {
        if (!entrenadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        entrenador.setId_entrenador(id);
        return ResponseEntity.ok(entrenadorService.save(entrenador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!entrenadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        entrenadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

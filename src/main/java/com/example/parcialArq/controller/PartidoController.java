package com.example.parcialArq.controller;


import com.example.parcialArq.models.Partido;
import com.example.parcialArq.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partido")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> getAll() {
        return partidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getById(@PathVariable Integer id) {
        return partidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido create(@RequestBody Partido partido) {
        return partidoService.save(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> update(@PathVariable Integer id, @RequestBody Partido partido) {
        if (!partidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        partido.setId_partido(id);
        return ResponseEntity.ok(partidoService.save(partido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!partidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        partidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/resultados")
    public List<Object[]> getResultados() {
        return partidoService.obtenerResultadosDePartidos();
    }
}

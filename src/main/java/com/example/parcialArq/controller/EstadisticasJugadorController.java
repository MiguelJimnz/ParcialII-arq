package com.example.parcialArq.controller;

import com.example.parcialArq.models.EstadisticasJugador;
import com.example.parcialArq.service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticasjugador")
public class EstadisticasJugadorController {
    @Autowired
    private EstadisticasJugadorService estadisticaJugadorService;

    @GetMapping
    public List<EstadisticasJugador> getAll() {
        return estadisticaJugadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> getById(@PathVariable Integer id) {
        return estadisticaJugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EstadisticasJugador create(@RequestBody EstadisticasJugador estadistica) {
        return estadisticaJugadorService.save(estadistica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> update(@PathVariable Integer id, @RequestBody EstadisticasJugador estadistica) {
        if (!estadisticaJugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estadistica.setId_estadistica(id);
        return ResponseEntity.ok(estadisticaJugadorService.save(estadistica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!estadisticaJugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estadisticaJugadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/goles-equipo/{idEquipo}")
    public Integer golesPorEquipo(@PathVariable Integer idEquipo) {
        return estadisticaJugadorService.obtenerGolesTotalesPorEquipo(idEquipo);
    }
}

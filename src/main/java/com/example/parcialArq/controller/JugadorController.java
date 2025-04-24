package com.example.parcialArq.controller;

import com.example.parcialArq.models.Jugador;
import com.example.parcialArq.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> getAll() {
        return jugadorService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getById(@PathVariable Integer id) {
        return jugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Jugador create(@RequestBody Jugador jugador) {
        jugador.setId_jugador(null);
        return jugadorService.save(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> update(@PathVariable Integer id, @RequestBody Jugador jugador) {
        if (!jugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        jugador.setId_jugador(id);
        return ResponseEntity.ok(jugadorService.save(jugador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!jugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        jugadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/equipo/{idEquipo}")
    public List<Jugador> jugadoresPorEquipo(@PathVariable Integer idEquipo) {
        return jugadorService.jugadoresPorEquipo(idEquipo);
    }

    @GetMapping("/goles/{cantidad}")
    public List<Jugador> jugadoresConMasDeXGoles(@PathVariable int cantidad) {
        return jugadorService.jugadoresConMasDeXGoles(cantidad);
    }
}

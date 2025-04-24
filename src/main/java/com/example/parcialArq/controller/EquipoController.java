package com.example.parcialArq.controller;

import com.example.parcialArq.models.Equipo;
import com.example.parcialArq.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipo> getAll() {
        return equipoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getById(@PathVariable Integer id) {
        return equipoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipo create(@RequestBody Equipo equipo) {
        return equipoService.save(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> update(@PathVariable Integer id, @RequestBody Equipo equipo) {
        if (!equipoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipo.setId_equipo(id);
        return ResponseEntity.ok(equipoService.save(equipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!equipoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

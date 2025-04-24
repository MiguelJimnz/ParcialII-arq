package com.example.parcialArq.service;


import com.example.parcialArq.models.Jugador;
import com.example.parcialArq.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Optional<Jugador> findById(Integer id) {
        return jugadorRepository.findById(id);
    }

    public void deleteById(Integer id) {
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> jugadoresPorEquipo(Integer idEquipo) {
        return jugadorRepository.findByEquipoId(idEquipo);
    }

    public List<Jugador> jugadoresConMasDeXGoles(int goles) {
        return jugadorRepository.findJugadoresConMasDeXGoles(goles);
    }
}

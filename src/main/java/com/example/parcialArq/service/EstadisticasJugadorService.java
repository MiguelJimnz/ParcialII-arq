package com.example.parcialArq.service;


import com.example.parcialArq.models.EstadisticasJugador;
import com.example.parcialArq.repository.EstadisticaJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasJugadorService {
    @Autowired
    private EstadisticaJugadorRepository estadisticaJugadorRepository;

    public List<EstadisticasJugador> findAll() {
        return estadisticaJugadorRepository.findAll();
    }

    public Optional<EstadisticasJugador> findById(Integer id) {
        return estadisticaJugadorRepository.findById(id);
    }

    public EstadisticasJugador save(EstadisticasJugador estadistica) {
        return estadisticaJugadorRepository.save(estadistica);
    }

    public void deleteById(Integer id) {
        estadisticaJugadorRepository.deleteById(id);
    }

    public Integer obtenerGolesTotalesPorEquipo(Integer idEquipo) {
        return estadisticaJugadorRepository.totalGolesEquipo(idEquipo);
    }
}

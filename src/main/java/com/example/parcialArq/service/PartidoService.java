package com.example.parcialArq.service;


import com.example.parcialArq.models.Partido;
import com.example.parcialArq.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> findAll() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> findById(Integer id) {
        return partidoRepository.findById(id);
    }

    public Partido save(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void deleteById(Integer id) {
        partidoRepository.deleteById(id);
    }

    public List<Object[]> obtenerResultadosDePartidos() {
        return partidoRepository.obtenerResultadosDePartidos();
    }
}

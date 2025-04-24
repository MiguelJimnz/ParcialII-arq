package com.example.parcialArq.service;


import com.example.parcialArq.models.Entrenador;
import com.example.parcialArq.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> findById(Integer id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void deleteById(Integer id) {
        entrenadorRepository.deleteById(id);
    }
}

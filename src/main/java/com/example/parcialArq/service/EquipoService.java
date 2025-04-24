package com.example.parcialArq.service;

import com.example.parcialArq.models.Equipo;
import com.example.parcialArq.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> findById(Integer id) {
        return equipoRepository.findById(id);
    }

    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteById(Integer id) {
        equipoRepository.deleteById(id);
    }
}

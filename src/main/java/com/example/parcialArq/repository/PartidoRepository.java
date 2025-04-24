package com.example.parcialArq.repository;

import com.example.parcialArq.models.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido,Integer> {

    @Query(value = "SELECT p.id_partido, el.nombre AS equipo_local, ev.nombre AS equipo_visita, p.goles_local, p.goles_visita " +
            "FROM partido p " +
            "JOIN equipo el ON p.equipo_local = el.id_equipo " +
            "JOIN equipo ev ON p.equipo_visita = ev.id_equipo", nativeQuery = true)
    List<Object[]> obtenerResultadosDePartidos();
}

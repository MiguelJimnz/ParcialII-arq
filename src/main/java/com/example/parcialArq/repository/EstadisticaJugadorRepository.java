package com.example.parcialArq.repository;

import com.example.parcialArq.models.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstadisticaJugadorRepository extends JpaRepository<EstadisticasJugador,Integer> {

    @Query(value = "SELECT SUM(e.goles) FROM estadisticas_jugador e " +
            "JOIN jugador j ON e.id_jugador = j.id_jugador " +
            "WHERE j.id_equipo = :idEquipo", nativeQuery = true)
    Integer totalGolesEquipo(@Param("idEquipo") Integer idEquipo);
}

package com.example.parcialArq.repository;

import com.example.parcialArq.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador,Integer> {



    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugador> findByEquipoId(@Param("idEquipo") Integer idEquipo);


    @Query(value = "SELECT j.* FROM jugador j " +
            "JOIN estadisticas_jugador e ON j.id_jugador = e.id_jugador " +
            "GROUP BY j.id_jugador " +
            "HAVING SUM(e.goles) > :goles", nativeQuery = true)
    List<Jugador> findJugadoresConMasDeXGoles(@Param("goles") int goles);
}

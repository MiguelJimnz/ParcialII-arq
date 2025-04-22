package com.example.parcialArq.models;


import jakarta.persistence.*;

@Entity
public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estadistica;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;

    private Integer minutos_jugados;
    private Integer goles;
    private Integer asistencias;
    private Integer tarjetas_amarillas;
    private Integer tarjetas_rojas;

}

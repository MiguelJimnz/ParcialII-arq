package com.example.parcialArq.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_jugador;

    private String nombre;
    private String posicion;
    private Integer dorsal;
    private Date fecha_nac;
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    private List<EstadisticasJugador> estadisticas;
}

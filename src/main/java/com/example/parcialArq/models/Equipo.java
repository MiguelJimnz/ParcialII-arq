package com.example.parcialArq.models;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_equipo;

    private String nombre;
    private String ciudad;
    private LocalDate fundacion;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo")
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipoLocal")
    private List<Partido> partidosComoLocal;

    @OneToMany(mappedBy = "equipoVisita")
    private List<Partido> partidosComoVisitante;

}

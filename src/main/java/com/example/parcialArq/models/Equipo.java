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

    public Equipo() {
    }

    public Equipo(Integer id_equipo, String nombre, String ciudad, LocalDate fundacion, List<Jugador> jugadores, List<Entrenador> entrenadores, List<Partido> partidosComoLocal, List<Partido> partidosComoVisitante) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;
        this.jugadores = jugadores;
        this.entrenadores = entrenadores;
        this.partidosComoLocal = partidosComoLocal;
        this.partidosComoVisitante = partidosComoVisitante;
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public List<Partido> getPartidosComoLocal() {
        return partidosComoLocal;
    }

    public void setPartidosComoLocal(List<Partido> partidosComoLocal) {
        this.partidosComoLocal = partidosComoLocal;
    }

    public List<Partido> getPartidosComoVisitante() {
        return partidosComoVisitante;
    }

    public void setPartidosComoVisitante(List<Partido> partidosComoVisitante) {
        this.partidosComoVisitante = partidosComoVisitante;
    }
}

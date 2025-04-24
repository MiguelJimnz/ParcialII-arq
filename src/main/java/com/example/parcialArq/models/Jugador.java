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

    public Jugador() {
    }

    public Jugador(Integer id_jugador, String nombre, String posicion, Integer dorsal, Date fecha_nac, String nacionalidad, Equipo equipo, List<EstadisticasJugador> estadisticas) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
        this.estadisticas = estadisticas;
    }

    public Integer getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(Integer id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<EstadisticasJugador> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<EstadisticasJugador> estadisticas) {
        this.estadisticas = estadisticas;
    }
}

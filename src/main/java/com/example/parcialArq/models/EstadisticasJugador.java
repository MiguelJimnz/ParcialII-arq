package com.example.parcialArq.models;


import jakarta.persistence.*;

@Entity
@Table(name = "estadisticas_jugador")
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

    public EstadisticasJugador() {
    }

    public EstadisticasJugador(Integer id_estadistica, Jugador jugador, Partido partido, Integer minutos_jugados, Integer goles, Integer asistencias, Integer tarjetas_amarillas, Integer tarjetas_rojas) {
        this.id_estadistica = id_estadistica;
        this.jugador = jugador;
        this.partido = partido;
        this.minutos_jugados = minutos_jugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjetas_amarillas = tarjetas_amarillas;
        this.tarjetas_rojas = tarjetas_rojas;
    }

    public Integer getId_estadistica() {
        return id_estadistica;
    }

    public void setId_estadistica(Integer id_estadistica) {
        this.id_estadistica = id_estadistica;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Integer getMinutos_jugados() {
        return minutos_jugados;
    }

    public void setMinutos_jugados(Integer minutos_jugados) {
        this.minutos_jugados = minutos_jugados;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getTarjetas_amarillas() {
        return tarjetas_amarillas;
    }

    public void setTarjetas_amarillas(Integer tarjetas_amarillas) {
        this.tarjetas_amarillas = tarjetas_amarillas;
    }

    public Integer getTarjetas_rojas() {
        return tarjetas_rojas;
    }

    public void setTarjetas_rojas(Integer tarjetas_rojas) {
        this.tarjetas_rojas = tarjetas_rojas;
    }
}

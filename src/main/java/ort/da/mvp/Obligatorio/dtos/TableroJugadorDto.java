package ort.da.mvp.Obligatorio.dtos;

import java.util.List;

import ort.da.mvp.Obligatorio.modelo.Jugador;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadApuesta;

public class TableroJugadorDto {
    public JugadorDto jugador;
    public List<CarreraDisponibleDto> carrerasDisponibles;
    public List<ModalidadDto> modalidades;
    public List<ApuestaDto> apuestas;

    public TableroJugadorDto(Jugador jugador, List<CarreraDisponibleDto> carreras, List<ModalidadApuesta> modalidades) {
        this.jugador = new JugadorDto(jugador);
        this.carrerasDisponibles = carreras;
        this.modalidades = ModalidadDto.listaDtos(modalidades);
        this.apuestas = ApuestaDto.listaDtos(jugador.getApuestas());
    }
}
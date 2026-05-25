package ort.da.mvp.Obligatorio.dtos;
import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.dtos.ParticipacionDto;
import ort.da.mvp.Obligatorio.modelo.Carrera;

public class CarreraDto {
    public int numero;
    public String nombre;
    public String estado;
    public double totalApostado;
    public int cantidadApuestas;
    public int cantidadCaballos;
    public List<ParticipacionDto> participaciones;
    public String CaballoGanador;

    public CarreraDto(Carrera carrera) {
        this.numero = carrera.getNumero();
        this.nombre = carrera.getNombre();
        this.estado = carrera.getEstado().getNombre();
        this.totalApostado = carrera.getTotalApostado();
        this.cantidadApuestas = carrera.getCantidadApuestas();
        this.cantidadCaballos = carrera.getParticipaciones().size();
        this.participaciones = ParticipacionDto.listaDtos(carrera.getParticipaciones());
        this.CaballoGanador = carrera.getNombreGanador();
    }

    public static List<CarreraDto> listaDtos(List<Carrera> carreras) {
        List<CarreraDto> dtos = new ArrayList<>();
        for (Carrera c : carreras) {
            dtos.add(new CarreraDto(c));
        }
        return dtos;
    }
}
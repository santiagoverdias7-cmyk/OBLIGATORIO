package ort.da.mvp.Obligatorio.dtos;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.modelo.Carrera;

public class CarreraDisponibleDto {
    public String fecha;
    public int numero;
    public String nombre;
    public List<ParticipacionDto> participaciones;

    public CarreraDisponibleDto(Carrera carrera, String fecha) {
        this.fecha = fecha;
        this.numero = carrera.getNumero();
        this.nombre = carrera.getNombre();
        this.participaciones = ParticipacionDto.listaDtos(carrera.getParticipaciones());
    }
public static List<CarreraDisponibleDto> listaDtos(List<Carrera> carreras, String fecha) {
        List<CarreraDisponibleDto> dtos = new ArrayList<>();
        for (Carrera c : carreras) {
            dtos.add(new CarreraDisponibleDto(c, fecha));
        }
        return dtos;
    }

}

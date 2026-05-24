package ort.da.mvp.Obligatorio.dtos;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.modelo.Participacion;

public class ParticipacionDto {
     public int numero;
    public String nombreCaballo;
    public double dividendo;
    public boolean dividendoValido;
    public double totalApostado;
    public int cantidadApuestas;

    public ParticipacionDto(Participacion participacion) {
        this.numero = participacion.getNumero();
        this.nombreCaballo = participacion.getCaballo().getNombre();
        this.dividendo = participacion.getDividendo().getValor();
        this.dividendoValido = participacion.getDividendo().isValido();
        this.totalApostado = participacion.getTotalApostado();
        this.cantidadApuestas = participacion.getCantidadApuestas();
    }

public static List<ParticipacionDto> listaDtos(List<Participacion> participaciones) {
        List<ParticipacionDto> dtos = new ArrayList<>();
        for (Participacion p : participaciones) {
            dtos.add(new ParticipacionDto(p));
        }
        return dtos;
    }


}

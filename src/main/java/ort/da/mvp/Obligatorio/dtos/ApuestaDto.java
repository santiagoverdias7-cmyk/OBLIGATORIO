package ort.da.mvp.Obligatorio.dtos;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.modelo.Apuesta;

public class ApuestaDto {
    public int numeroCarrera;
    public String nombreCarrera;
    public int numeroCaballo;
    public String nombreCaballo;
    public double montoApostado;
    public String tipoApuesta;
    public double montoCobrado;
    public double dividendoFinal;
    public String estado; //es para saber si la carrera en donde realizo la apuesta ya se corrio o no

 public ApuestaDto(Apuesta apuesta) {
        this.numeroCarrera = apuesta.getParticipacion().getCarrera().getNumero();
        this.nombreCarrera = apuesta.getParticipacion().getCarrera().getNombre();
        this.numeroCaballo = apuesta.getParticipacion().getNumero();
        this.nombreCaballo = apuesta.getParticipacion().getCaballo().getNombre();
        this.montoApostado = apuesta.getMontoApostado();
        this.tipoApuesta = apuesta.getModalidad().getNombre();
        this.montoCobrado = apuesta.getMontoCobrado();
        this.dividendoFinal = apuesta.getParticipacion().getDividendoFinal();
        this.estado = apuesta.getParticipacion().getCarrera().esFinalizada() ? "Finalizada" : "Por correr";
    }

    public static List<ApuestaDto> listaDtos(List<Apuesta> apuestas) {
        List<ApuestaDto> dtos = new ArrayList<>();
        for (Apuesta a : apuestas) {
            dtos.add(new ApuestaDto(a));
        }
        return dtos;
    }


}

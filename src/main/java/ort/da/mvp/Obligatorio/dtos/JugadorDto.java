package ort.da.mvp.Obligatorio.dtos;

import ort.da.mvp.Obligatorio.modelo.Jugador;

public class JugadorDto {
    public String nombreCompleto;
    public double saldo;
    public double totalApostado;
    public double totalGanado;

  public JugadorDto(Jugador jugador) {
        this.nombreCompleto = jugador.getNombreCompleto();
        this.saldo = jugador.getSaldo();
        this.totalApostado = jugador.getTotalApostado();
        this.totalGanado = jugador.getTotalGanado();
    }


}

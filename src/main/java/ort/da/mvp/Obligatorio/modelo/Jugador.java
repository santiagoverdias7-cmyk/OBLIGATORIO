package ort.da.mvp.Obligatorio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Usuario {

   private Double saldo;
   private List<Apuesta> apuestas;

    public Jugador(String nombreUsuario, String password, String nombreCompleto, double saldo) {
        super(nombreUsuario, password, nombreCompleto);
        this.saldo = saldo;
         this.apuestas = new ArrayList<>();
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
     public List<Apuesta> getApuestas() { return apuestas; }

    public void agregarApuesta(Apuesta apuesta) {
        apuestas.add(apuesta);
    }   
    
   public double getTotalApostado() {
    double total = 0;
    for (Apuesta a : apuestas) {
        total += a.getModalidad().calcularCosto(a.getMontoApostado());
    }
    return total;
}
 
 public double getTotalGanado() {
        double total = 0;
        for (Apuesta a : apuestas) {
            total += a.getMontoCobrado();
        }
        return total;
    }

 public boolean tieneSaldo(double monto) {
        return saldo >= monto;
    }

    public void acreditar(double monto) {
        saldo += monto;
    }

    public void debitar(double monto) {
        saldo -= monto;
    }

}

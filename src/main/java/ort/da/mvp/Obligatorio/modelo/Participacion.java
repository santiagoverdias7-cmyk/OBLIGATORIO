package ort.da.mvp.Obligatorio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Participacion {
     private int numero; // número del caballo en la carrera
    private Dividendo dividendo;
    private Caballo caballo;
    private Carrera carrera;
    private List<Apuesta> apuestas; //nose si dejarlo asi o poner como hizo el profe una apuesta sola.

    
    public Participacion(int numero, Caballo caballo, Carrera carrera) {
    this.numero = numero;
    this.caballo = caballo;
    this.carrera = carrera;
    this.dividendo = new Dividendo();
    this.apuestas = new ArrayList<>();
}
    
    
    
    
    
    public int getNumero() { return numero; }
    public Caballo getCaballo() { return caballo; }
    public Dividendo getDividendo() { return dividendo; }
    public Carrera getCarrera() { return carrera; }
    public List<Apuesta> getApuestas() { return apuestas; }

public void agregarApuesta(Apuesta apuesta) {
        apuestas.add(apuesta);
    }

    public int getCantidadApuestas() {
        return apuestas.size();
    }

   public double getTotalApostado() {
    double total = 0;
    for (Apuesta apuesta : apuestas) {
        total += apuesta.getMontoApostado();
    }
    return total;
}

public double getTotalPagado() {
    double total = 0;
    for (Apuesta a : apuestas) {
        total += a.getMontoCobrado();
    }
    return total;
}



}

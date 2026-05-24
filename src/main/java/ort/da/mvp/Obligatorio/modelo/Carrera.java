package ort.da.mvp.Obligatorio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int numero;
    private String nombre;
    private EstadoCarrera estado;
    private Participacion participacionGanadora;
    private List<Participacion> participaciones;
    
        public Carrera(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
        this.estado = new Definida();
        this.participacionGanadora = null;
        this.participaciones = new ArrayList<>();
    }

public int getNumero() { return numero; }
public String getNombre() { return nombre; }
public EstadoCarrera getEstado() { return estado; }
public Participacion getParticipacionGanadora() { return participacionGanadora; }
public List<Participacion> getParticipaciones() { return participaciones; }




public void setEstado(EstadoCarrera estado) { this.estado = estado; }
    public void setParticipacionGanadora(Participacion p) { this.participacionGanadora = p; }

    public void agregarParticipacion(Participacion participacion) {
        participaciones.add(participacion);
    }

    public double getTotalApostado() {
        double total = 0;
        for (Participacion p : participaciones) {
            total += p.getTotalApostado();
        }
        return total;
    }

    public int getCantidadApuestas() {
        int total = 0;
        for (Participacion p : participaciones) {
            total += p.getCantidadApuestas();
        }
        return total;
    }

    public void recalcularDividendos(double comision) {
        double totalCarrera = getTotalApostado();
        for (Participacion p : participaciones) {
            p.getDividendo().actualizar(totalCarrera, comision, p.getTotalApostado());
        }
    }

public boolean esFinalizada() {
    return estado instanceof Finalizada;
}

public double getTotalPagado() {
    double total = 0;
    for (Participacion p : participaciones) {
        total += p.getTotalPagado();
    }
    return total;
}




}

package ort.da.mvp.Obligatorio.modelo;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.modelo.estadoCarrera.Definida;
import ort.da.mvp.Obligatorio.modelo.estadoCarrera.EstadoCarrera;
import ort.da.mvp.Obligatorio.modelo.estadoCarrera.Finalizada;

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

//metodos que delegan al estado
public void abrir() { estado.abrir(this); }
public void cerrar() { estado.cerrar(this); }
public void finalizar() { estado.finalizar(this); }
public void recalcularEstado() { estado.recalcularEstado(this); }   

public boolean todosDividendosValidos() {
    for (Participacion p : participaciones) {
        if (!p.getDividendo().EsValido()) {
            return false;
        }
    }
    return true;
}

public Participacion buscarParticipacion(int numero) {
    for (Participacion p : participaciones) {
        if (p.getNumero() == numero) {
            return p;
        }
    }
    return null;    
}


public String getNombreGanador() {
    if (participacionGanadora != null) {
        return participacionGanadora.getCaballo().getNombre();
    }
    return null;
}




}
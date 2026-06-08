package ort.da.mvp.Obligatorio.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.dtos.CarreraDisponibleDto;

public class Jornada {
    
    private LocalDate fecha;
    private List<Carrera> carreras;

    public Jornada(LocalDate fecha) {    
        this.fecha = fecha;
        this.carreras = new ArrayList<>();
    }

public LocalDate getFecha() {
        return fecha;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

//REVISAR
public double getTotalApostado() {
    double total = 0;
    for (Carrera c : carreras) {
        total += c.getTotalApostado();
    }
    return total;
}
public double getTotalPagado() {
    double total = 0;
    for (Carrera c : carreras) {
        total += c.getTotalPagado();
    }
    return total;
}


/*public double getTotalComisiones(double comision) {
    return getTotalApostado() * (comision / 100);
}*/

public double getTotalComisiones() {
    return getTotalApostado() * 0.10;
} //esto se debera cambiar una vez se cree la clase de comisionHipodromo



public double getBalance() {
    return getTotalApostado() - getTotalPagado();
}

public int getCantidadFinalizadas() {
    int count = 0;
    for (Carrera c : carreras) {
        if (c.esFinalizada()) count++;
    }
    return count;
}

public int getCantidadPorCorrer() {
    return carreras.size() - getCantidadFinalizadas();
}

public List<Carrera> getCarrerasFinalizadas() {
    List<Carrera> result = new ArrayList<>();
    for (Carrera c : carreras) {
        if (c.esFinalizada()) result.add(c);
    }
    return result;
}


public List<Carrera> getProximasCarreras() {
    List<Carrera> result = new ArrayList<>();
    for (Carrera c : carreras) {
        if (!c.esFinalizada()) result.add(c);
    }
    return result;
}

public Carrera buscarCarrera(int numero) {
    for (Carrera c : carreras) {
        if (c.getNumero() == numero) {
            return c;
        }
    }
    return null;
}


//para tablero jugador CU
public void agregarCarrerasDisponiblesDto(List<CarreraDisponibleDto> lista) {
    for (Carrera c : carreras) {
        if (c.estaDisponibleParaApostar()) {
            lista.add(new CarreraDisponibleDto(c, getFecha().toString()));
        }
    }
}




}

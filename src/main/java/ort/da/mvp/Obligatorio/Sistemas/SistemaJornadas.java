package ort.da.mvp.Obligatorio.Sistemas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.dtos.CarreraDisponibleDto;
import ort.da.mvp.Obligatorio.modelo.Carrera;
import ort.da.mvp.Obligatorio.modelo.Jornada;

public class SistemaJornadas {
    private List<Jornada> jornadas;
    public SistemaJornadas() {
        this.jornadas = new ArrayList<>();
    }

    public void agregarJornada(Jornada jornada) {
        jornadas.add(jornada);
    }   

    public List<Jornada> getJornadas() {
        return jornadas;
    }
    
   //metodo para obtener jornada actual
   public Jornada getJornadaActual() {
    LocalDate hoy = LocalDate.now();
    Jornada resultado = null;
    for (Jornada j : jornadas) {
        if (j.getFecha().isEqual(hoy) || j.getFecha().isBefore(hoy)) {
            if (resultado == null || j.getFecha().isAfter(resultado.getFecha())) {
                resultado = j;
            }
        }
    }
    return resultado;
}



public Jornada getJornadaAnterior(Jornada jornadaActual) {
    Jornada resultado = null;
    for (Jornada j : jornadas) {
        if (j.getFecha().isBefore(jornadaActual.getFecha())) {
            if (resultado == null || j.getFecha().isAfter(resultado.getFecha())) {
                resultado = j;
            }
        }
    }
    return resultado;
}

public Jornada getJornadaSiguiente(Jornada jornadaActual) {
    Jornada resultado = null;
    for (Jornada j : jornadas) {
        if (j.getFecha().isAfter(jornadaActual.getFecha())) {
            if (resultado == null || j.getFecha().isBefore(resultado.getFecha())) {
                resultado = j;
            }
        }
    }
    return resultado;
}



/*public Carrera buscarCarreraEnJornadaActual(int numero){

    Jornada actual= getJornadaActual();
    if (actual == null) return null;
    for (Carrera c : actual.getCarreras()) {
        if (c.getNumero() == numero) {
            return c;
        }
    }
    return null;
}*/

public Carrera buscarCarreraEnJornada(int numero, LocalDate fecha) {
    for (Jornada j : jornadas) {
        if (j.getFecha().equals(fecha)) {
            return j.buscarCarrera(numero);
        }
    }
    return null;
}






public void abrirCarrera(Carrera carrera) {
    carrera.abrir();
}

public void cerrarCarrera(Carrera carrera) {
    carrera.cerrar();
}

//revisar este metodo
public void finalizarCarrera(Carrera carrera, int numeroGanador) {
    carrera.setParticipacionGanadora(carrera.buscarParticipacion(numeroGanador));
    carrera.finalizar();
   
}


public List<CarreraDisponibleDto> getCarrerasDisponibles() {
    List<CarreraDisponibleDto> disponibles = new ArrayList<>();
    for (Jornada j : jornadas) {
        j.agregarCarrerasDisponiblesDto(disponibles);
    }
    return disponibles;
}



}

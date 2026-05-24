package ort.da.mvp.Obligatorio.Sistemas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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






}

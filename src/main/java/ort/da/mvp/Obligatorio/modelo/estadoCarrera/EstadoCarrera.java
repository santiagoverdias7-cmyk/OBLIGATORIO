package ort.da.mvp.Obligatorio.modelo.estadoCarrera;

import ort.da.mvp.Obligatorio.modelo.Carrera;

public abstract class EstadoCarrera {
    public abstract String getNombre();

    public void abrir(Carrera carrera) {
        throw new UnsupportedOperationException("No se puede abrir la carrera en estado " + getNombre());
    }
    public void cerrar(Carrera carrera) {
        throw new UnsupportedOperationException("No se puede cerrar la carrera en estado " + getNombre());
    }
    public void finalizar(Carrera carrera) {
        throw new UnsupportedOperationException("No se puede finalizar la carrera en estado " + getNombre());
    }
    public void recalcularEstado(Carrera carrera) {
        //solo abierta lo necesita, por defecto no hace nada
    }

    public boolean estaDisponibleParaApostar() {
    return false;
}

public boolean esFinalizada() {
    return false;
}

}

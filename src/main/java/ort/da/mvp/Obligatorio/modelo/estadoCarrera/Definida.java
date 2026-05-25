package ort.da.mvp.Obligatorio.modelo.estadoCarrera;

import ort.da.mvp.Obligatorio.modelo.Carrera;

//este es el estado inicial, solo puede pasar a abierta
public class Definida extends EstadoCarrera {
    public String getNombre() { return "Definida"; }

@Override
public void abrir(Carrera carrera) {
    carrera.setEstado(new Abierta());
}

}

package ort.da.mvp.Obligatorio.modelo.estadoCarrera;
import ort.da.mvp.Obligatorio.modelo.Carrera;

//Todos los dividendos ya son validos, solo se puede cerrar
public class Estable extends EstadoCarrera {
    public String getNombre() { return "Estable"; }

@Override
public void cerrar(Carrera carrera) {
    carrera.setEstado(new Cerrada());   
}

}

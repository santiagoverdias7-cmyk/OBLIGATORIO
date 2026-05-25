package ort.da.mvp.Obligatorio.modelo.estadoCarrera;
import ort.da.mvp.Obligatorio.modelo.Carrera;
//se aceptan apuestas, se debe recalcular el estado tras cada apuesta
// si todos los dividendos son validos pasa a estable 
public class Abierta extends EstadoCarrera {
    public String getNombre() { return "Abierta"; }

@Override
 public void recalcularEstado(Carrera carrera) {
     if (carrera.todosDividendosValidos()) {
         carrera.setEstado(new Estable());
     }
 }


}

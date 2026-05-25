package ort.da.mvp.Obligatorio.modelo.estadoCarrera;
import ort.da.mvp.Obligatorio.modelo.Carrera;
//no se aceptan mas apuestas solo puede finalizarse
public class Cerrada extends EstadoCarrera {
    public String getNombre() { return "Cerrada"; }

@Override
public void finalizar(Carrera carrera) {
    carrera.setEstado(new Finalizada());   
}

    
}

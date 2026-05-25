package ort.da.mvp.Obligatorio.modelo.estadoCarrera;
import ort.da.mvp.Obligatorio.modelo.Carrera;
//NO PERMITE MAS TRANSICIONES
//LA carrera ya tiene ganador y las apuestas finalizadas
public class Finalizada extends EstadoCarrera {
    public String getNombre() { return "Finalizada"; }
}
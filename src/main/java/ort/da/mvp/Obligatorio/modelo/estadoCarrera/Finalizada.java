package ort.da.mvp.Obligatorio.modelo.estadoCarrera;
//LA carrera ya tiene ganador y las apuestas finalizadas
public class Finalizada extends EstadoCarrera {
    public String getNombre() { return "Finalizada"; }
  
@Override
public boolean esFinalizada() {
    return true;
}

}
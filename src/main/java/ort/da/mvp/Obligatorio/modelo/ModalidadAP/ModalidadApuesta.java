package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public abstract class ModalidadApuesta {
    private String nombre;
    public ModalidadApuesta(String nombre) {
        this.nombre = nombre;
    }
    
 public String getNombre() {
        return nombre;
    }

    
public abstract double calcularCosto(double montoApostado);
public abstract double calcularPremio(double montoApostado, double dividendo, double totalApostadoCaballo);
}

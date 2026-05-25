package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public class DescuentoTriple implements CalculadorDescuento {
    // estrategia concreta, costo= monto apostado + 50% del monto apostado
    public double calcular(double montoApostado){
        return montoApostado * 1.5;
    }
    
}

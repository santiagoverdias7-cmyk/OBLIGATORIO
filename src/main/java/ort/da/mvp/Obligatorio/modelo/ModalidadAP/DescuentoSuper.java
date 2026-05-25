package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public class DescuentoSuper implements CalculadorDescuento {
    // estrategia concreta, costo= monto apostado + 100% del monto apostado
    public double calcular(double montoApostado){
        return montoApostado * 2;
    }
    
}

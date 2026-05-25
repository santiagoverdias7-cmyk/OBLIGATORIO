package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public class DescuentoSimple implements CalculadorDescuento {
// estrategia concreta, costo= monto apostado sin ningun recargo
 public double calcular(double montoApostado){
 return montoApostado;
    }  
}

package ort.da.mvp.Obligatorio.modelo.ModalidadAP;
// aplicandolo a  strategy: define el contrato para calcular el descuento/costo de una apuesta
public interface  CalculadorDescuento {
    double calcular(double montoApostado);
}

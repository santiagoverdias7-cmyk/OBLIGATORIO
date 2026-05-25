package ort.da.mvp.Obligatorio.modelo.ModalidadAP;
// strategy, igual que la otra intefaz, define el contrato para calcualr el premio/pago de una apuesta ganadora
public interface  CalculadorPremio {
    double calcular(double montoApostado, double dividendo, double totalApostadoCaballo);
}

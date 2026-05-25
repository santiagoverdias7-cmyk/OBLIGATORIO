package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

// Estrategia concreta: premio = monto * dividendo
public class PremioSimple implements CalculadorPremio {
    public double calcular(double montoApostado, double dividendo, double totalApostadoCaballo) {
        return montoApostado * dividendo;
    }
}

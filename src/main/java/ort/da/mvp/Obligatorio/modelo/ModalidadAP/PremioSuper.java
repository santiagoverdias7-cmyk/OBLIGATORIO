package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public class PremioSuper implements CalculadorPremio{
    

 public double calcular(double montoApostado, double dividendo, double totalApostadoCaballo) {
        if (dividendo >= 2) {
            return montoApostado * dividendo * 3;
        }
        return montoApostado * dividendo * 4;
    }


}

package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public class PremioTriple implements CalculadorPremio {
// Estrategia concreta: premio = monto * dividendo * 2 si totalApostadoCaballo < 100.000
//                               monto * dividendo * 3 si totalApostadoCaballo >= 100.000
    public double calcular(double montoApostado, double dividendo , double totalApostadoCaballo){
        if (totalApostadoCaballo >=100000) {
            return montoApostado * dividendo * 3;
        } else {
            return montoApostado * dividendo * 2;
        }
    }   
    
}

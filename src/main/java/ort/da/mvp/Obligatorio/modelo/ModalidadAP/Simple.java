package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public class Simple extends ModalidadApuesta {
    private CalculadorDescuento calculadorDescuento;
    private CalculadorPremio calculadorPremio;
    //Modalidad simple no tiene recargo en el costo.
    
    public Simple() {
        super("Simple");
        this.calculadorDescuento = new DescuentoSimple();
        this.calculadorPremio = new PremioSimple();
    }

 public double calcularCosto(double montoApostado) {
        return calculadorDescuento.calcular(montoApostado);
    }

    public double calcularPremio(double montoApostado, double dividendo, double totalApostadoCaballo) {
        return calculadorPremio.calcular(montoApostado, dividendo, totalApostadoCaballo);
    }

}
